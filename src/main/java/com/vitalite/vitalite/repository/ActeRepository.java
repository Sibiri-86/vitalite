package com.vitalite.vitalite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Acte;

@Repository
public interface ActeRepository extends JpaRepository<Acte, Long> {
    List<Acte> findByDeletedFalse();
    List<Acte> findByFamilleActeIdAndDeletedFalse(Long familleId);
    List<Acte> findByFamilleActeCodeAndDeletedFalse(String code);
    Optional<Acte>findByCodeAndDeletedFalse(String code);
}
