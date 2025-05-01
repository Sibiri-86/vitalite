package com.vitalite.vitalite.model;


public class PharmacieDto {
    private Long id;
    private String code;
    private String libelle;
    private String sousActeCode;
    private String pharmaCode;
    private Long sousActeId;
    
    

    
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
    
    

    
}
