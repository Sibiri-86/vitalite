package com.vitalite.vitalite.model;

import java.math.BigDecimal;

public class TauxDto {
    private Long id;
    private BigDecimal tauxPourcentage;
    

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getTauxPourcentage() {
        return tauxPourcentage;
    }
    public void setTauxPourcentage(BigDecimal tauxPourcentage) {
        this.tauxPourcentage = tauxPourcentage;
    }
    
        
}
