package com.vitalite.vitalite.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DossierClientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String numDossier;
    private String target;
    private Long assureurId;
    private String assureur;
    private LocalDate dateNaissance;
    private LocalDate dateSaissie;
    private Long tauxId;
    private BigDecimal taux;
    private Long acteId;
    
    
    
    public BigDecimal getTaux() {
        return taux;
    }
    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNumDossier() {
        return numDossier;
    }
    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    public Long getAssureurId() {
        return assureurId;
    }
    public void setAssureurId(Long assureurId) {
        this.assureurId = assureurId;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public LocalDate getDateSaissie() {
        return dateSaissie;
    }
    public void setDateSaissie(LocalDate dateSaissie) {
        this.dateSaissie = dateSaissie;
    }
    public String getAssureur() {
        return assureur;
    }
    public void setAssureur(String assureur) {
        this.assureur = assureur;
    }
    
    
   
    @Override
    public String toString() {
        return "DossierClientDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule
                + ", numDossier=" + numDossier + ", target=" + target + ", assureurId=" + assureurId + ", assureur="
                + assureur + ", dateNaissance=" + dateNaissance + ", dateSaissie=" + dateSaissie + ", taux=" + taux + "]";
    }
    
    public Long getTauxId() {
        return tauxId;
    }
    public void setTauxId(Long tauxId) {
        this.tauxId = tauxId;
    }
    public Long getActeId() {
        return acteId;
    }
    public void setActeId(Long acteId) {
        this.acteId = acteId;
    }
   
    
    
    
  
    
    
}
