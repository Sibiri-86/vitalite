package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDeletedFalse();
}
