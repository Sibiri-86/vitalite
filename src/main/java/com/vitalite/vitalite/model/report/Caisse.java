package com.vitalite.vitalite.model.report;

import java.math.BigDecimal;

public class Caisse {
    private String sousActe;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private BigDecimal montant;
    private BigDecimal montantAssurer;
    private BigDecimal montantTotal;
    private BigDecimal montantTotalAssurer;
    private BigDecimal montantTotalAssureur;

    
    public String getSousActe() {
        return sousActe;
    }
    public void setSousActe(String sousActe) {
        this.sousActe = sousActe;
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

    

    


    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
    public BigDecimal getMontantTotalAssurer() {
        return montantTotalAssurer;
    }
    public void setMontantTotalAssurer(BigDecimal montantTotalAssurer) {
        this.montantTotalAssurer = montantTotalAssurer;
    }
    public BigDecimal getMontantTotalAssureur() {
        return montantTotalAssureur;
    }
    public void setMontantTotalAssureur(BigDecimal montantTotalAssureur) {
        this.montantTotalAssureur = montantTotalAssureur;
    }
    
   
    public BigDecimal getMontantAssurer() {
        return montantAssurer;
    }
    public void setMontantAssurer(BigDecimal montantAssurer) {
        this.montantAssurer = montantAssurer;
    }

    public Caisse() {
    }
    public Caisse(String sousActe, BigDecimal quantite, BigDecimal prixUnitaire, BigDecimal montant,
            BigDecimal montantAssurer, BigDecimal montantTotal, BigDecimal montantTotalAssurer,
            BigDecimal montantTotalAssureur) {
        this.sousActe = sousActe;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montant = montant;
        this.montantAssurer = montantAssurer;
        this.montantTotal = montantTotal;
        this.montantTotalAssurer = montantTotalAssurer;
        this.montantTotalAssureur = montantTotalAssureur;
    }


    
    
}
