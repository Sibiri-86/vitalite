package com.vitalite.vitalite.model;

import java.time.LocalDate;
import java.util.List;

public class ConventionDto {
    private Long id;
    private LocalDate dateEffet;
    private Long assureurId;
    private List<ActeDto> actes;
    private String assureur;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getDateEffet() {
        return dateEffet;
    }
    public void setDateEffet(LocalDate dateEffet) {
        this.dateEffet = dateEffet;
    }
    public Long getAssureurId() {
        return assureurId;
    }
    public void setAssureurId(Long assureurId) {
        this.assureurId = assureurId;
    }
    public List<ActeDto> getActes() {
        return actes;
    }
    public void setActes(List<ActeDto> actes) {
        this.actes = actes;
    }
    public String getAssureur() {
        return assureur;
    }
    public void setAssureur(String assureur) {
        this.assureur = assureur;
    }
        
}
