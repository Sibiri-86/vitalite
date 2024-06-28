/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitalite.vitalite.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "sousActe")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SousActe   implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    private String code;
    private String libelle;
    private Boolean deleted = Boolean.FALSE;
    public BigDecimal prixActe;
    private String valeurNormal;
    @ManyToOne
    @JsonIgnoreProperties("sousActes")
    private Acte acte;
    @ManyToOne
    @JsonIgnoreProperties("sousActes")
    private FamilleActe familleActe;

    
    public FamilleActe getFamilleActe() {
        return familleActe;
    }

    public void setFamilleActe(FamilleActe familleActe) {
        this.familleActe = familleActe;
    }

    public String getValeurNormal() {
        return valeurNormal;
    }

    public void setValeurNormal(String valeurNormal) {
        this.valeurNormal = valeurNormal;
    }

    public Acte getActe() {
        return acte;
    }

    public void setActe(Acte acte) {
        this.acte = acte;
    }

    public BigDecimal getPrixActe() {
        return prixActe;
    }

    public void setPrixActe(BigDecimal prixActe) {
        this.prixActe = prixActe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    

    
}

