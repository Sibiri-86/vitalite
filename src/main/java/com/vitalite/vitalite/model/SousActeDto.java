package com.vitalite.vitalite.model;

import java.math.BigDecimal;

public class SousActeDto {
    private Long id;
    private String code;
    private String libelle;
    private BigDecimal montantConvention;
    private Long conventionActeId;
    public BigDecimal prixActe;
    private Long acteId;
    private String libelleActe;
    private String valeurNormal;
    private Long familleActeId;
    private String acteCode;

    
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public BigDecimal getMontantConvention() {
        return montantConvention;
    }
    public void setMontantConvention(BigDecimal montantConvention) {
        this.montantConvention = montantConvention;
    }
    public Long getConventionActeId() {
        return conventionActeId;
    }
    public void setConventionActeId(Long conventionActeId) {
        this.conventionActeId = conventionActeId;
    }
    public BigDecimal getPrixActe() {
        return prixActe;
    }
    public void setPrixActe(BigDecimal prixActe) {
        this.prixActe = prixActe;
    }
    public Long getActeId() {
        return acteId;
    }
    public void setActeId(Long acteId) {
        this.acteId = acteId;
    }
    public String getLibelleActe() {
        return libelleActe;
    }
    public void setLibelleActe(String libelleActe) {
        this.libelleActe = libelleActe;
    }
    public String getValeurNormal() {
        return valeurNormal;
    }
    public void setValeurNormal(String valeurNormal) {
        this.valeurNormal = valeurNormal;
    }
    public Long getFamilleActeId() {
        return familleActeId;
    }
    public void setFamilleActeId(Long familleActeId) {
        this.familleActeId = familleActeId;
    }
    public String getActeCode() {
        return acteCode;
    }
    public void setActeCode(String acteCode) {
        this.acteCode = acteCode;
    }
    

    
}
