package com.vitalite.vitalite.model;

import java.time.LocalDate;

public class SearchDto {
    LocalDate dateD;
    LocalDate dateF;
    Long assureurId;

    
   
   
    public LocalDate getDateD() {
        return dateD;
    }
    public void setDateD(LocalDate dateD) {
        this.dateD = dateD;
    }
    public LocalDate getDateF() {
        return dateF;
    }
    public void setDateF(LocalDate dateF) {
        this.dateF = dateF;
    }
    public Long getAssureurId() {
        return assureurId;
    }
    public void setAssureurId(Long assureurId) {
        this.assureurId = assureurId;
    }

    
   
    
}
