package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.ConventionActe;

@Repository
public interface ConventionActeRepository extends JpaRepository<ConventionActe, String> {
    List<ConventionActe> findByDeletedFalse();
    List<ConventionActe> findByConventionIdAndDeletedFalse(Long conventId);
}
