package com.vitalite.vitalite.model;

import java.time.LocalDate;
import java.util.List;



public class SoinDto {
    private Long id;
    private String numSoin;
    private LocalDate dateSaisie;
    private String patient;
    private Long dossierClientId;
    private List<PrestationDto> prestations;
    private Boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumSoin() {
        return numSoin;
    }
    public void setNumSoin(String numSoin) {
        this.numSoin = numSoin;
    }
    public LocalDate getDateSaisie() {
        return dateSaisie;
    }
    public void setDateSaisie(LocalDate dateSaisie) {
        this.dateSaisie = dateSaisie;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    public String getPatient() {
        return patient;
    }
    public void setPatient(String patient) {
        this.patient = patient;
    }
    public Long getDossierClientId() {
        return dossierClientId;
    }
    public void setDossierClientId(Long dossierClientId) {
        this.dossierClientId = dossierClientId;
    }


    public List<PrestationDto> getPrestations() {
        return prestations;
    }
    public void setPrestations(List<PrestationDto> prestations) {
        this.prestations = prestations;
    }
    @Override
    public String toString() {
        return "SoinDto [id=" + id + ", numSoin=" + numSoin + ", dateSaisie=" + dateSaisie + ", patient=" + patient
                + ", dossierClientId=" + dossierClientId + ", prestations=" + prestations + ", deleted=" + deleted
                + "]";
    }
    

    

    

    
}
