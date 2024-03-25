package com.vitalite.vitalite.model;

import java.time.LocalDate;

public class SearchDto {
    LocalDate datD;
    LocalDate datF;
    public LocalDate getDatD() {
        return datD;
    }
    public void setDatD(LocalDate datD) {
        this.datD = datD;
    }
    public LocalDate getDatF() {
        return datF;
    }
    public void setDatF(LocalDate datF) {
        this.datF = datF;
    }
    @Override
    public String toString() {
        return "SearchDto [datD=" + datD + ", datF=" + datF + "]";
    }

    
   
    
}
