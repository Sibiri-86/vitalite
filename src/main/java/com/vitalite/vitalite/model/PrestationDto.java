package com.vitalite.vitalite.model;

import java.math.BigDecimal;
import java.time.LocalDate;



public class PrestationDto {
    private Long id;
    private Long dossierClientId;
    private Long acteId;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private BigDecimal montant;
    private LocalDate dateSaisie;
    private Long soinId;

    private Boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getDossierClientId() {
        return dossierClientId;
    }
    public void setDossierClientId(Long dossierClientId) {
        this.dossierClientId = dossierClientId;
    }
    public Long getActeId() {
        return acteId;
    }
    public void setActeId(Long acteId) {
        this.acteId = acteId;
    }
    public BigDecimal getQuantite() {
        return quantite;
    }
    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }
    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public BigDecimal getMontant() {
        return montant;
    }
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    
    public LocalDate getDateSaisie() {
        return dateSaisie;
    }
    public void setDateSaisie(LocalDate dateSaisie) {
        this.dateSaisie = dateSaisie;
    }
    public Long getSoinId() {
        return soinId;
    }
    public void setSoinId(Long soinId) {
        this.soinId = soinId;
    }
    @Override
    public String toString() {
        return "PrestationDto [id=" + id + ", dossierClientId=" + dossierClientId + ", acteId=" + acteId + ", quantite="
                + quantite + ", prixUnitaire=" + prixUnitaire + ", montant=" + montant + ", dateSaisie=" + dateSaisie
                + ", soinId=" + soinId + ", deleted=" + deleted + "]";
    }
    
    
  
    
    
}
