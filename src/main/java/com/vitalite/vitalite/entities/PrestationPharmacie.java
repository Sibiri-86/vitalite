/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitalite.vitalite.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "prestation_pharmacie")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PrestationPharmacie  implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

   
    @ManyToOne
    @JoinColumn(name = "prestation_id",referencedColumnName="id",insertable=true,updatable=true)
    private Prestation  prestation;

    @ManyToOne
    @JoinColumn(name = "pharmacie_id",referencedColumnName="id",insertable=true,updatable=true)
    private Pharmacie  pharmacie;

    @ManyToOne
    @JoinColumn(name = "sousActe_id",referencedColumnName="id",insertable=true,updatable=true)
    private SousActe  sousActe;
   
    

    private BigDecimal quantite;
    private BigDecimal montant;
    private BigDecimal montantAssureur;
    private BigDecimal montantPaye;
    private BigDecimal montantTotal;
    private LocalDate dateSaisie;
    private Boolean deleted = Boolean.FALSE;

    
  

    public SousActe getSousActe() {
        return sousActe;
    }

    public void setSousActe(SousActe sousActe) {
        this.sousActe = sousActe;
    }

    public Prestation getPrestation() {
        return prestation;
    }

    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public BigDecimal getMontantAssureur() {
        return montantAssureur;
    }

    public void setMontantAssureur(BigDecimal montantAssureur) {
        this.montantAssureur = montantAssureur;
    }

    public BigDecimal getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(LocalDate dateSaisie) {
        this.dateSaisie = dateSaisie;
    }
   

    
       

    
}

