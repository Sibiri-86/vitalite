package com.vitalite.vitalite.model;


public class ExamenDto {
    private Long id;
    private String code;
    private String libelle;
    private String categorie;
    private Long categorieId;
    private String unite; 
    
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
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public Long getCategorieId() {
        return categorieId;
    }
    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
    public String getUnite() {
        return unite;
    }
    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    

    
}
