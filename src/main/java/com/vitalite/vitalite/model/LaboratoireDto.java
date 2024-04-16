package com.vitalite.vitalite.model;

import java.time.LocalDate;
import java.util.List;




public class LaboratoireDto {
    private Long id;
    private Long patientId;
    private PatientDto patient;
    private List<PrestationDto> prestations;
   
    private LocalDate dateSaissie;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   
    public void setDateSaissie(LocalDate dateSaissie) {
        this.dateSaissie = dateSaissie;
    }
    public List<PrestationDto> getPrestations() {
        return prestations;
    }
    public void setPrestations(List<PrestationDto> prestations) {
        this.prestations = prestations;
    }
    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public PatientDto getPatient() {
        return patient;
    }
    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }
    public LocalDate getDateSaissie() {
        return dateSaissie;
    }
   
    

    }
