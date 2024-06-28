package com.vitalite.vitalite.model;

import java.math.BigDecimal;
import java.util.List;




public class ArreteDto {
    private BigDecimal total;
    List<PatientDto> patients;
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public List<PatientDto> getPatients() {
        return patients;
    }
    public void setPatients(List<PatientDto> patients) {
        this.patients = patients;
    }
    public ArreteDto(BigDecimal total, List<PatientDto> patients) {
        this.total = total;
        this.patients = patients;
    }
    
    
    }
