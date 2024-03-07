package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Assureur;

@Repository
public interface AssureurRepository extends JpaRepository<Assureur, String> {
    List<Assureur> findByDeletedFalse();
}
