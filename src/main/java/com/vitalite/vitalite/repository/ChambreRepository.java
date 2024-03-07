package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Chambre;


@Repository
public interface ChambreRepository extends JpaRepository<Chambre, String> {
    List<Chambre> findByDeletedFalse();
}
