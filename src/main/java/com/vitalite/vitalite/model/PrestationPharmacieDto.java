package com.vitalite.vitalite.model;

import java.math.BigDecimal;
import java.time.LocalDate;



public class PrestationPharmacieDto {
    private Long id;
    private Long prestationId;
    private Long pharmacieId;
    private BigDecimal quantite;
    private BigDecimal montant;
    private LocalDate dateSaisie;
    private BigDecimal montantTotal;
    private BigDecimal montantPaye;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPrestationId() {
        return prestationId;
    }
    public void setPrestationId(Long prestationId) {
        this.prestationId = prestationId;
    }
    public Long getPharmacieId() {
        return pharmacieId;
    }
    public void setPharmacieId(Long pharmacieId) {
        this.pharmacieId = pharmacieId;
    }
    public BigDecimal getQuantite() {
        return quantite;
    }
    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }
    public BigDecimal getMontant() {
        return montant;
    }
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
    public LocalDate getDateSaisie() {
        return dateSaisie;
    }
    public void setDateSaisie(LocalDate dateSaisie) {
        this.dateSaisie = dateSaisie;
    }
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
    public BigDecimal getMontantPaye() {
        return montantPaye;
    }
    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }

    
   
    
  
    
    
}
