package com.vitalite.vitalite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.vitalite.vitalite.entities.Produit;



@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByDeletedFalse();
}
