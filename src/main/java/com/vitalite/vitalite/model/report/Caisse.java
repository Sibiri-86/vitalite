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
    private Long famille_acte_id;
    private String valeur;
    private String valeurNormales;
    private String nomActe;
    private String donneeCaisse;

    
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
    public Long getFamille_acte_id() {
        return famille_acte_id;
    }
    public void setFamille_acte_id(Long famille_acte_id) {
        this.famille_acte_id = famille_acte_id;
    }
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    public String getValeurNormales() {
        return valeurNormales;
    }
    public void setValeurNormales(String valeurNormales) {
        this.valeurNormales = valeurNormales;
    }
    public String getNomActe() {
        return nomActe;
    }
    public void setNomActe(String nomActe) {
        this.nomActe = nomActe;
    }
    public String getDonneeCaisse() {
        return donneeCaisse;
    }
    public void setDonneeCaisse(String donneeCaisse) {
        this.donneeCaisse = donneeCaisse;
    }


    
    
}
