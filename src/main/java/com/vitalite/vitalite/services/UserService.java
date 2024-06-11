package com.vitalite.vitalite.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.MapperAware;
import com.vitalite.vitalite.entities.Authority;
import com.vitalite.vitalite.entities.Profil;
import com.vitalite.vitalite.model.UserDTO;
import com.vitalite.vitalite.repository.AuthorityRepository;
import com.vitalite.vitalite.repository.ProfilRepository;
import com.vitalite.vitalite.repository.UserRepository;
import com.vitalite.vitalite.security.AuthoritiesConstants;
import com.vitalite.vitalite.security.Role;
import com.vitalite.vitalite.security.SecurityUtils;
import com.vitalite.vitalite.security.User;
import com.vitalite.vitalite.services.util.Constants;
import com.vitalite.vitalite.services.util.RandomUtil;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;
    private final  ProfilRepository profilRepository;

    private final Mapper mapper;
     private final CacheManager cacheManager;
    

    
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,CacheManager cacheManager,Mapper mapper,
      AuthorityRepository authorityRepository, ProfilRepository profilRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.cacheManager = cacheManager;
        this.profilRepository = profilRepository;
        this.mapper = mapper;
    }

    public Optional<User> activateRegistration(String key) {
        log.debug("Activating user for activation key {}", key);
        return userRepository.findOneByActivationKey(key)
            .map(user -> {
                // activate given user for the registration key.
                user.setActivated(true);
                user.setActivationKey(null);
                this.clearUserCaches(user);
                log.debug("Activated user: {}", user);
                return user;
            });
    }

    public Optional<User> completePasswordReset(String newPassword, String key) {
        log.debug("Reset user password for reset key {}", key);
        return userRepository.findOneByResetKey(key)
            .filter(user -> user.getResetDate().isAfter(Instant.now().minusSeconds(86400)))
            .map(user -> {
                user.setPassword(passwordEncoder.encode(newPassword));
                user.setResetKey(null);
                user.setResetDate(null);
                this.clearUserCaches(user);
                return user;
            });
    }

    public Optional<User> requestPasswordReset(String mail) {
        return userRepository.findOneByEmailIgnoreCase(mail)
            .filter(User::isActivated)
            .map(user -> {
                user.setResetKey(RandomUtil.generateResetKey());
                user.setResetDate(Instant.now());
                this.clearUserCaches(user);
                return user;
            });
    }

    public User registerUser(UserDTO userDTO, String password) {
        userRepository.findOneByEmail(userDTO.getEmail().toLowerCase()).ifPresent(existingUser -> {
            boolean removed = removeNonActivatedUser(existingUser);
            if (!removed) {
                // throw new LoginAlreadyUsedException();
            }
        });
        userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).ifPresent(existingUser -> {
            boolean removed = removeNonActivatedUser(existingUser);
            if (!removed) {
               // throw new EmailAlreadyUsedException();
            }
        });
        User newUser = new User();
        String encryptedPassword = passwordEncoder.encode(password);
        // newUser.setLo(userDTO.getLogin().toLowerCase());
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setFirstname(userDTO.getFirstName());
        newUser.setLastname(userDTO.getLastName());
        newUser.setEmail(userDTO.getEmail().toLowerCase());
        newUser.setLangKey(userDTO.getLangKey());
        // new user is not active
        newUser.setActivated(false);
        newUser.setPassChange(false);
        System.out.println("=================userDTO========="+userDTO.getRole());
        newUser.setRole(Role.USER);
        // new user gets registration key
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        Optional<Profil> profil = profilRepository.findById(userDTO.getProfileId());
        if(profil.isPresent()) {
            Set<Profil> profils = new HashSet<>();
            profils.add(profil.get());
            newUser.setProfils(new HashSet<>(profils));

        }
       
       /*  Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(userDTO.getRole().toString()).ifPresent(authorities::add);
       newUser.setAuthorities(authorities);*/
       System.out.println("=================newUser========="+newUser.getRole());

        userRepository.save(newUser);
        this.clearUserCaches(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    private boolean removeNonActivatedUser(User existingUser){
        if (existingUser.isActivated()) {
             return false;
        }
        userRepository.delete(existingUser);
        userRepository.flush();
        this.clearUserCaches(existingUser);
        return true;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstName());
        user.setLastname(userDTO.getLastName());
        user.setEmail(userDTO.getEmail().toLowerCase());
        if (userDTO.getLangKey() == null) {
            user.setLangKey(Constants.DEFAULT_LANGUAGE); // default language
        } else {
            user.setLangKey(userDTO.getLangKey());
        }
        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        user.setActivated(true);
        if (userDTO.getAuthorities() != null) {
            Set<Authority> authorities = userDTO.getAuthorities().stream()
                .map(authorityRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
           user.setAuthorities(authorities);
        }
       
        userRepository.save(user);
        this.clearUserCaches(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

    /**
     * Update basic information (first name, last name, email, language) for the current user.
     *
     * @param firstName first name of user
     * @param lastName last name of user
     * @param email email id of user
     * @param langKey language key
     * @param imageUrl image URL of user
     */
    public void updateUser(String firstName, String lastName, String email, String langKey, String imageUrl) {
        SecurityUtils.getCurrentUserLogin()
            .flatMap(userRepository::findOneByEmail)
            .ifPresent(user -> {
                user.setFirstname(firstName);
                user.setLastname(lastName);
                user.setEmail(email.toLowerCase());
                user.setLangKey(langKey);
                this.clearUserCaches(user);
                log.debug("Changed Information for User: {}", user);
            });
    }

    /**
     * Update all information for a specific user, and return the modified user.
     *
     * @param userDTO user to update
     * @return updated user
     */
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        
        return null;
    }

    public void deleteUser(String login) {
        userRepository.findOneByEmail(login).ifPresent(user -> {
            userRepository.delete(user);
            this.clearUserCaches(user);
            log.debug("Deleted User: {}", user);
        });
    }

    public void changePassword(String currentClearTextPassword, String newPassword) {
        SecurityUtils.getCurrentUserLogin()
            .flatMap(userRepository::findOneByEmail)
            .ifPresent(user -> {
                String currentEncryptedPassword = user.getPassword();
                if (!passwordEncoder.matches(currentClearTextPassword, currentEncryptedPassword)) {
                    throw  null;
                }
                String encryptedPassword = passwordEncoder.encode(newPassword);
                user.setPassword(encryptedPassword);
                this.clearUserCaches(user);
                log.debug("Changed password for User: {}", user);
            });
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllManagedUsers(Pageable pageable) {
       // return null;
         return userRepository.findAllByEmailNot(pageable, Constants.ANONYMOUS_USER).map(t-> new UserDTO());
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthoritiesByLogin(String login) {
        return userRepository.findByEmail(login);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(Long id) {
        return userRepository.findOneWithAuthoritiesById(id);
    }

    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserWithAuthorities() {
        Optional<User> user = SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneWithAuthoritiesByEmail);
        user.ifPresent(user1 -> user1.setAuthorities(new HashSet<>(findUserProfilWithAuthorities(user1.getEmail()))));
       
        UserDTO userDTO = mapper.map(user.get(), UserDTO.class);
        if(!userDTO.getAuthorities().isEmpty()) {
            userDTO.getAuthorities().addAll(user.get().getAuthoritiesList().stream().map(Authority::getName).collect(Collectors.toList()));
          //  System.out.println("===========user1=========1=================="+ userDTO.getAuthorities());

        }
        return Optional.of(userDTO);
        }

         /**
     * Les rôles par profil d'un utilisateur.
     * @param email
     * @return List<Authority>
     */
    private List<Authority> findUserProfilWithAuthorities(String email) {
        Optional<User> user = userRepository.findOneByEmail(email);
         return user.map(user1 -> new ArrayList<>(user1.getProfils().stream().findFirst().get()
             .getAuthorities())).orElse(null);
     }
    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     */
   /*  @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        userRepository
            .findAllByActivatedIsFalseAndCreatedDateBefore(Instant.now().minus(3, ChronoUnit.DAYS))
            .forEach(user -> {
                log.debug("Deleting not activated user {}", user.getEmail());
                userRepository.delete(user);
                this.clearUserCaches(user);
            });
    } */

    /**
     * @return a list of all the authorities
     */
    public List<String> getAuthorities() {
        return authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
    }

     private void clearUserCaches(User user) {
       // Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_LOGIN_CACHE)).evict(user.getEmail());
        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_EMAIL_CACHE)).evict(user.getEmail());
    } 
}
