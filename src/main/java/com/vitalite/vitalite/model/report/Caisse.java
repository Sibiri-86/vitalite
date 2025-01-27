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
    private String numeroBon;
    private String numeroMatricule;
    private String beneficiaire;
    private String societe;
    private BigDecimal montantDemander;
    private String dateSoins;
    private BigDecimal montantTotalDemander;
    private BigDecimal montantTotalDu;
    private BigDecimal montantNonRemb;
    private BigDecimal tpec;
    private String acte;

    
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

    public String getNumeroBon() {
        return numeroBon;
    }
    public void setNumeroBon(String numeroBon) {
        this.numeroBon = numeroBon;
    }
    public String getNumeroMatricule() {
        return numeroMatricule;
    }
    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }
    public String getBeneficiaire() {
        return beneficiaire;
    }
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
    public BigDecimal getMontantDemander() {
        return montantDemander;
    }
    public void setMontantDemander(BigDecimal montantDemander) {
        this.montantDemander = montantDemander;
    }
    public Caisse() {
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

    public String getSociete() {
        return societe;
    }
    public void setSociete(String societe) {
        this.societe = societe;
    }

    

    
    public BigDecimal getMontantTotalDemander() {
        return montantTotalDemander;
    }
    public void setMontantTotalDemander(BigDecimal montantTotalDemander) {
        this.montantTotalDemander = montantTotalDemander;
    }
    public BigDecimal getMontantTotalDu() {
        return montantTotalDu;
    }
    public void setMontantTotalDu(BigDecimal montantTotalDu) {
        this.montantTotalDu = montantTotalDu;
    }

    public String getDateSoins() {
        return dateSoins;
    }
    public void setDateSoins(String dateSoins) {
        this.dateSoins = dateSoins;
    }

    
    public BigDecimal getmontantNonRemb() {
        return montantNonRemb;
    }
    public void setMontantNonremb(BigDecimal montantNonRemb) {
        this.montantNonRemb = montantNonRemb;
    }
    public BigDecimal getTpec() {
        return tpec;
    }
    public void setTpec(BigDecimal tpec) {
        this.tpec = tpec;
    }
    public String getActe() {
        return acte;
    }
    public void setActe(String acte) {
        this.acte = acte;
    }
    public Caisse(String sousActe, BigDecimal quantite, BigDecimal prixUnitaire, BigDecimal montant,
            BigDecimal montantAssurer, BigDecimal montantTotal, BigDecimal montantTotalAssurer,
            BigDecimal montantTotalAssureur, Long famille_acte_id, String valeur, String valeurNormales, String nomActe,
            String donneeCaisse, String numeroBon, String numeroMatricule, String beneficiaire, String societe,
            BigDecimal montantDemander, String dateSoins, BigDecimal montantTotalDemander, BigDecimal montantTotalDu) {
        this.sousActe = sousActe;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montant = montant;
        this.montantAssurer = montantAssurer;
        this.montantTotal = montantTotal;
        this.montantTotalAssurer = montantTotalAssurer;
        this.montantTotalAssureur = montantTotalAssureur;
        this.famille_acte_id = famille_acte_id;
        this.valeur = valeur;
        this.valeurNormales = valeurNormales;
        this.nomActe = nomActe;
        this.donneeCaisse = donneeCaisse;
        this.numeroBon = numeroBon;
        this.numeroMatricule = numeroMatricule;
        this.beneficiaire = beneficiaire;
        this.societe = societe;
        this.montantDemander = montantDemander;
        this.dateSoins = dateSoins;
        this.montantTotalDemander = montantTotalDemander;
        this.montantTotalDu = montantTotalDu;
    }


    
    
}
