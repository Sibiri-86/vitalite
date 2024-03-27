package com.vitalite.vitalite.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ConventionActeDto {
    private Long id;
    private LocalDate dateEffet;
    private LocalDate dateEcheance;
    private Long conventionId; 
    private Long sousActeId;
    private BigDecimal montantConvention;
    private Boolean deleted = Boolean.FALSE;

    
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
    public LocalDate getDateEcheance() {
        return dateEcheance;
    }
    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
    public Long getConventionId() {
        return conventionId;
    }
    public void setConventionId(Long conventionId) {
        this.conventionId = conventionId;
    }
    
    public BigDecimal getMontantConvention() {
        return montantConvention;
    }
    public void setMontantConvention(BigDecimal montantConvention) {
        this.montantConvention = montantConvention;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    public Long getSousActeId() {
        return sousActeId;
    }
    public void setSousActeId(Long sousActeId) {
        this.sousActeId = sousActeId;
    }
    
        
}
