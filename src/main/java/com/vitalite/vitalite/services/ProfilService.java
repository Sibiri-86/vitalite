package com.vitalite.vitalite.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Authority;
import com.vitalite.vitalite.entities.Profil;
import com.vitalite.vitalite.model.AuthorityDto;
import com.vitalite.vitalite.model.ProfilDto;
import com.vitalite.vitalite.repository.AuthorityRepository;
import com.vitalite.vitalite.repository.ProfilRepository;
import com.vitalite.vitalite.repository.UserRepository;
import com.vitalite.vitalite.security.AuthoritiesConstants;
import com.vitalite.vitalite.security.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfilService {

    private final Logger log = LoggerFactory.getLogger(ProfilService.class);

    private final ProfilRepository profilRepository;

    private final UserRepository userRepository;
     @Autowired
     private Mapper mapper;

    private final AuthorityRepository authorityRepository;

    public ProfilService(AuthorityRepository authorityRepository, UserRepository userRepository, ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }


    public List<AuthorityDto> findAllAuthorities() {
        return authorityRepository.findAll().stream().map(a->mapper.map(a, AuthorityDto.class)).collect(Collectors.toList());
    }
    /**
     *
     * @param prof
     * @return
     */

    public Profil save(ProfilDto prof) {
        Set<Authority> authorities = prof.getAuthorities();
        System.out.println("==================oui========");  
        prof.setAuthorities(authorities);
        if(prof.getId() != null) {
            Profil profil1 = profilRepository.findById(prof.getId()).get();
            if (profil1.getAuthorities().size() != authorities.size()) {
                
                List<User> users = userRepository.findAllWithProfilsByEmailNot(AuthoritiesConstants.ADMIN);

                for (User user : users) {
                    if (user.getProfils().contains(profil1)) {
                        System.out.println("==================oui=====1==="+user.getAuthoritiesList()); 
                        user.getProfils().remove(profil1);
                      /*   if(!user.getAuthorities().isEmpty()) {
                            user.getAuthorities().clear();
                        } */
                        if(!user.getAuthoritiesList().isEmpty()) {
                            user.getAuthoritiesList().clear();
                        } 
                        
                        user.getProfils().add(mapper.map(prof, Profil.class));
                        user.getProfils().forEach(profi -> user.getAuthoritiesList().addAll(prof.getAuthorities()));
                        userRepository.saveAndFlush(user);
                    }
                }
            }
        }

        return profilRepository.saveAndFlush(mapper.map(prof, Profil.class));
    }

    /**
     *
     * @return
     */

    @Transactional(readOnly = true)
    public List<Profil> findAll() {
        log.debug("Request to get all Profils");
        return profilRepository.findAllWithEagerRelationships()
            .stream().sorted(Comparator.comparing(Profil::getProfilName, String.CASE_INSENSITIVE_ORDER))
            .collect(Collectors.toList());
    }

    /**
     *
     * @param pageable
     * @return
     */

    public Page<Profil> findAllWithEagerRelationships(Pageable pageable) {
        return profilRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<Profil> findOne(Long id) {
        log.debug("Request to get Profil : {}", id);
        return profilRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the profil by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
        Profil profil = profilRepository.getOne(id);
        profilRepository.deleteById(id);

        List<User> users = userRepository.findAllWithProfilsByEmailNot(AuthoritiesConstants.ADMIN);

        users.stream().filter(user -> user.getProfils().contains(profil)).forEach(user -> {
            user.getProfils().remove(profil);
            user.getAuthorities().clear();
            user.getProfils().forEach(profi -> user.getAuthoritiesList().addAll(profi.getAuthorities()));
            userRepository.saveAndFlush(user);
        });

    }
}
