package com.vitalite.vitalite.model;


public class ActeDto {
    private Long id;
    private String code;
    private String libelle;
    private String familleActeCode;
    private Long familleActeId;
    private String libelleFamilleActe;
    private Boolean isExamen;

    
    
    

    
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
    public Long getFamilleActeId() {
        return familleActeId;
    }
    public void setFamilleActeId(Long familleActeId) {
        this.familleActeId = familleActeId;
    }
    public String getLibelleFamilleActe() {
        return libelleFamilleActe;
    }
    public void setLibelleFamilleActe(String libelleFamilleActe) {
        this.libelleFamilleActe = libelleFamilleActe;
    }
    public Boolean getIsExamen() {
        return isExamen;
    }
    public void setIsExamen(Boolean isExamen) {
        this.isExamen = isExamen;
    }
    public String getFamilleActeCode() {
        return familleActeCode;
    }
    public void setFamilleActeCode(String familleActeCode) {
        this.familleActeCode = familleActeCode;
    }
    
    

    
}
