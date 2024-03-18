package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Taux;

@Repository
public interface TauxRepository extends JpaRepository<Taux, Long> {
    List<Taux> findByDeletedFalse();
}
