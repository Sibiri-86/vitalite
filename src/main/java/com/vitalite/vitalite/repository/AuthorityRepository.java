package com.vitalite.vitalite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vitalite.vitalite.entities.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
