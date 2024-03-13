package com.vitalite.vitalite.model;

import java.time.LocalDate;


public class SoinDto {
    private Long id;
    private String numSoin;
    private LocalDate dateSaisie;
    private String patient;
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
    @Override
    public String toString() {
        return "SoinDto [id=" + id + ", numSoin=" + numSoin + ", dateSaisie=" + dateSaisie + ", patient=" + patient
                + ", deleted=" + deleted + "]";
    }

    
}
