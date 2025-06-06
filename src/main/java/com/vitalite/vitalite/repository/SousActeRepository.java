package com.vitalite.vitalite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.SousActe;


@Repository
public interface SousActeRepository extends JpaRepository<SousActe, Long> {
    List<SousActe> findByDeletedFalse();
    List<SousActe> findByActeIdAndDeletedFalse(Long acteId);
    List<SousActe> findByActeCodeAndDeletedFalse(String acteCode);
    Optional<SousActe> findByCodeAndDeletedFalse(String sousActeCode);
}
