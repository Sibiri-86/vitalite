package com.vitalite.vitalite.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;



public class PrestationDto {
    private Long id;
    private Long dossierClientId;
    private Long acteId;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private BigDecimal montant;
    private LocalDate dateSaisie;
    private Long soinId;
    private BigDecimal montantAssureur;
    private BigDecimal montantPaye;
    private Long tauxId;
    private BigDecimal tauxNew;
    private Long familleActeId;
    private Long sousActeId;
    private String libelleSousActe;
    private Long patientId;
    private SousActeDto sousActe;
    private String valeur;
    private String numeroBon;
    private List<PharmacieDto> pharmacieFormArray;

    

    
    public BigDecimal getMontantAssureur() {
        return montantAssureur;
    }
    public void setMontantAssureur(BigDecimal montantAssureur) {
        this.montantAssureur = montantAssureur;
    }
    public BigDecimal getMontantPaye() {
        return montantPaye;
    }
    public void setMontantPaye(BigDecimal montantPaye) {
        this.montantPaye = montantPaye;
    }
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
   
    public Long getTauxId() {
        return tauxId;
    }
    public void setTauxId(Long tauxId) {
        this.tauxId = tauxId;
    }
    
    public Long getFamilleActeId() {
        return familleActeId;
    }
    public void setFamilleActeId(Long familleActeId) {
        this.familleActeId = familleActeId;
    }
    public Long getSousActeId() {
        return sousActeId;
    }
    public void setSousActeId(Long sousActeId) {
        this.sousActeId = sousActeId;
    }
    public String getLibelleSousActe() {
        return libelleSousActe;
    }
    public void setLibelleSousActe(String libelleSousActe) {
        this.libelleSousActe = libelleSousActe;
    }
    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public BigDecimal getTauxNew() {
        return tauxNew;
    }
    public void setTauxNew(BigDecimal tauxNew) {
        this.tauxNew = tauxNew;
    }
    public SousActeDto getSousActe() {
        return sousActe;
    }
    public void setSousActe(SousActeDto sousActe) {
        this.sousActe = sousActe;
    }
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    public String getNumeroBon() {
        return numeroBon;
    }
    public void setNumeroBon(String numeroBon) {
        this.numeroBon = numeroBon;
    }
    public List<PharmacieDto> getPharmacieFormArray() {
        return pharmacieFormArray;
    }
    public void setPharmacieFormArray(List<PharmacieDto> pharmacieFormArray) {
        this.pharmacieFormArray = pharmacieFormArray;
    }
    
    
  
    
    
}
