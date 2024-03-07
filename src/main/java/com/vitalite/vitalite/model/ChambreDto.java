package com.vitalite.vitalite.model;

import java.math.BigDecimal;

import com.vitalite.vitalite.typeEnum.NombrePlace;
import com.vitalite.vitalite.typeEnum.TypeChambre;

public class ChambreDto {
    private Long id;
    private String code;
    private String libelle;
    private NombrePlace place;
    private TypeChambre typeChambre;
    private BigDecimal prix;
    
    
    public NombrePlace getPlace() {
        return place;
    }
    public void setPlace(NombrePlace place) {
        this.place = place;
    }
    public TypeChambre getTypeChambre() {
        return typeChambre;
    }
    public void setTypeChambre(TypeChambre typeChambre) {
        this.typeChambre = typeChambre;
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
    public BigDecimal getPrix() {
        return prix;
    }
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
    

    
}
