package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vitalite.vitalite.entities.Souscripteur;

@Repository
public interface SouscripteurRepository extends JpaRepository<Souscripteur, Long> {
    List<Souscripteur> findByDeletedFalse();
}
