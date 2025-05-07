package com.vitalite.vitalite.model;

import java.math.BigDecimal;

public class PharmacieDto {
    private Long id;
    private String code;
    private String libelle;
    private String sousActeCode;
    private String pharmaCode;
    private Long sousActeId;
    private BigDecimal quantite;
    private BigDecimal montant;
    private BigDecimal montantTotal;
    private BigDecimal montantPaye;
    private Long prestationId;
    
    

    
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
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
    public BigDecimal getMontantPaye() {
        return montantPaye;
    }
    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }
    public String getSousActeCode() {
        return sousActeCode;
    }
    public void setSousActeCode(String sousActeCode) {
        this.sousActeCode = sousActeCode;
    }
    public Long getSousActeId() {
        return sousActeId;
    }
    public void setSousActeId(Long sousActeId) {
        this.sousActeId = sousActeId;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getPharmaCode() {
        return pharmaCode;
    }
    public void setPharmaCode(String pharmaCode) {
        this.pharmaCode = pharmaCode;
    }
    public Long getPrestationId() {
        return prestationId;
    }
    public void setPrestationId(Long prestationId) {
        this.prestationId = prestationId;
    }
    
    
    

    
}
