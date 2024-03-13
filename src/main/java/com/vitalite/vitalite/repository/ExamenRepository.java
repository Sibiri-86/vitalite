package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Examen;



@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {
    List<Examen> findByDeletedFalse();
    List<Examen> findByCategorieIdAndDeletedFalse(Long categorieId);
}
