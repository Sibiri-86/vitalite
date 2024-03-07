package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Acte;

@Repository
public interface ActeRepository extends JpaRepository<Acte, String> {
    List<Acte> findByDeletedFalse();
}
