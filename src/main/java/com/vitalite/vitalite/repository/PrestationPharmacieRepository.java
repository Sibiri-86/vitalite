package com.vitalite.vitalite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.PrestationPharmacie;


@Repository
public interface PrestationPharmacieRepository extends JpaRepository<PrestationPharmacie, Long> {
    List<PrestationPharmacie> findByDeletedFalse();
    List<PrestationPharmacie> findByPrestationIdAndDeletedFalse(Long prestationId);
    List<PrestationPharmacie> findByPrestationIdAndSousActeIdAndDeletedFalse(Long prestationId, Long idSousActe);
    
}
