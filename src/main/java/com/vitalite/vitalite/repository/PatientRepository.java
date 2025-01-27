package com.vitalite.vitalite.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDeletedFalse();
    List<Patient> findByIsLaboFalseAndDeletedFalse();
    List<Patient> findByDeletedFalseAndAssureurIdAndDateSaissieBetween(Long assureurId, LocalDate dateD, LocalDate dateF);
    List<Patient> findByDeletedFalseAndDateSaissieBetween(LocalDate dateD, LocalDate dateF);
    List<Patient> findByDeletedFalseAndAssureurIdAndDateSaissieBetweenAndSouscripteurIdIsNotNull(Long assureurId, LocalDate dateD, LocalDate dateF);
    List<Patient> findByDeletedFalseAndAssureurIdAndDateSaissieBetweenAndSouscripteurId(Long assureurId, LocalDate dateD, LocalDate dateF, Long souscripteurId);
}
