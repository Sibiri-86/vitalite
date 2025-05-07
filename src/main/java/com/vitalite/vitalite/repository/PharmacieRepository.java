package com.vitalite.vitalite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Pharmacie;


@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long> {
    List<Pharmacie> findByDeletedFalse();
    Optional<Pharmacie> findByCodeAndDeletedFalse(String code);
    List<Pharmacie> findBySousActeIdAndDeletedFalse(Long sousActeId);
    List<Pharmacie> findBySousActeCodeAndDeletedFalse(String sousActeCode);
}
