package com.vitalite.vitalite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Convention;

@Repository
public interface ConventionRepository extends JpaRepository<Convention, Long> {
    List<Convention> findByDeletedFalse();
    Optional<Convention> findByAssureurIdAndDeletedFalse(Long assureurId);
}
