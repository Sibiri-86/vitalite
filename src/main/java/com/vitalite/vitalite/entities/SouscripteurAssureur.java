/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitalite.vitalite.entities;

import java.io.Serializable;

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
@Table(name = "SouscripteurAssureur")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SouscripteurAssureur  implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "souscripteur_id",referencedColumnName="id",insertable=true,updatable=true)
    private Souscripteur souscripteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assureur_id",referencedColumnName="id",insertable=true,updatable=true)
    private Assureur assureur;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Souscripteur getSouscripteur() {
        return souscripteur;
    }

    public void setSouscripteur(Souscripteur souscripteur) {
        this.souscripteur = souscripteur;
    }

    public Assureur getAssureur() {
        return assureur;
    }

    public void setAssureur(Assureur assureur) {
        this.assureur = assureur;
    }

    @Override
    public String toString() {
        return "SouscripteurAssureur [id=" + id + ", souscripteur=" + souscripteur + ", assureur=" + assureur
                + ", getId()=" + getId() + ", getSouscripteur()=" + getSouscripteur() + ", getAssureur()="
                + getAssureur() + ", toString()=" + super.toString() + "]";
    }

    

    

    
}

