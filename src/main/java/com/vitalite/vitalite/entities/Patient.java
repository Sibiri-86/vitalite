/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitalite.vitalite.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "patient")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Patient  implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String numDossier;
    private String target;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnoreProperties("patients")
    private Assureur assureur;
   
    private LocalDate dateNaissance;
    private LocalDate dateSaissie;
    private String police;
    private Boolean deleted = Boolean.FALSE;
    private Boolean isLabo;
   
    public Boolean getIsLabo() {
        return isLabo;
    }

    public void setIsLabo(Boolean isLabo) {
        this.isLabo = isLabo;
    }

    public String getPolice() {
        return police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public LocalDate getDateSaissie() {
        return dateSaissie;
    }

    public void setDateSaissie(LocalDate dateSaissie) {
        this.dateSaissie = dateSaissie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

   

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Assureur getAssureur() {
        return assureur;
    }

    public void setAssureur(Assureur assureur) {
        this.assureur = assureur;
    }

    
    
    @Override
    public String toString() {
        return "DossierClient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule
                + ", numDossier=" + numDossier + ", target=" + target + ", assureur=" + assureur + ", dateNaissance="
                + dateNaissance + ", deleted=" + deleted + "]";
    }

    
       

    
}

