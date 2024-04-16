package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Prestation;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {
    List<Prestation> findByDeletedFalse();
    List<Prestation> findBySoinIdAndDeletedFalse(Long soinId);
    List<Prestation> findByPatientIdAndDeletedFalse(Long patientId);
    List<Prestation> findByPatientIdAndActeIsExamenTrueAndDeletedFalse(Long patientId);
}
