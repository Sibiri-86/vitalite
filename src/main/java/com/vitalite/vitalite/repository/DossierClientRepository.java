package com.vitalite.vitalite.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.DossierClient;

@Repository
public interface DossierClientRepository extends JpaRepository<DossierClient, Long> {
    List<DossierClient> findByDeletedFalse();
    List<DossierClient> findByAndDateSaissieBetweenAndDeletedFalse(LocalDate dateD, LocalDate dateF);
}
