package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Laboratoire;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {
    List<Laboratoire> findByDeletedFalse();
}
