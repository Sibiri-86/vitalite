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
@Table(name = "prestation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Prestation  implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dossierClient_id",referencedColumnName="id",insertable=true,updatable=true)
    private DossierClient dossierClient;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acte_id",referencedColumnName="id",insertable=true,updatable=true)
    private Acte acte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soin_id",referencedColumnName="id",insertable=true,updatable=true)
    private Soin soin;

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private BigDecimal montant;
    private LocalDate dateSaisie;
    private Boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DossierClient getDossierClient() {
        return dossierClient;
    }

    public void setDossierClient(DossierClient dossierClient) {
        this.dossierClient = dossierClient;
    }

    public Acte getActe() {
        return acte;
    }

    public void setActe(Acte acte) {
        this.acte = acte;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
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

    public Soin getSoin() {
        return soin;
    }

    public void setSoin(Soin soin) {
        this.soin = soin;
    }

    

   

    
       

    
}

