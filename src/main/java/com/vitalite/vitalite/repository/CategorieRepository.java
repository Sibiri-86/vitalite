package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {
    List<Categorie> findByDeletedFalse();
}
