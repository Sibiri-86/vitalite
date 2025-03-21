package com.vitalite.vitalite.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vitalite.vitalite.security.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

Optional<User> findByEmail(String email);
Optional<User> findOneByActivationKey(String activationKey);

    //List<User> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findOneByEmailIgnoreCase(String email);

    Optional<User> findOneByEmail(String email);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesById(Long id);

   
    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<User> findOneWithAuthoritiesByEmail(String email);
 
    Page<User> findAllByEmailNot(Pageable pageable, String login);
    @EntityGraph(attributePaths = "authorities")
    List<User> findAllWithProfilsByEmailNot(String login);

    Page<User> findAll(Pageable pageable);



}
