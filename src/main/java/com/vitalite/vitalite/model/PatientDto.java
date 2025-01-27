package com.vitalite.vitalite.model;

import java.time.LocalDate;
import java.util.List;




public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String numDossier;
    private String target;
    private Long assureurId;
    private String assureur;
    private List<PrestationDto> prestations;
   
    private LocalDate dateNaissance;
    private LocalDate dateSaissie;
    private String police;
    private Boolean isLabo;
    private Boolean isValide;
    private Long souscripteurId;
    private String souscripteur;
    private String souscripteurCode;
    private String newSouscripteur;


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
    public String getAssureur() {
        return assureur;
    }
    public void setAssureur(String assureur) {
        this.assureur = assureur;
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
    public List<PrestationDto> getPrestations() {
        return prestations;
    }
    public void setPrestations(List<PrestationDto> prestations) {
        this.prestations = prestations;
    }
    public String getPolice() {
        return police;
    }
    public void setPolice(String police) {
        this.police = police;
    }
    public Boolean getIsLabo() {
        return isLabo;
    }
    public void setIsLabo(Boolean isLabo) {
        this.isLabo = isLabo;
    }
    public Boolean getIsValide() {
        return isValide;
    }
    public void setIsValide(Boolean isValide) {
        this.isValide = isValide;
    }
    public Long getSouscripteurId() {
        return souscripteurId;
    }
    public void setSouscripteurId(Long souscripteurId) {
        this.souscripteurId = souscripteurId;
    }
    public String getSouscripteur() {
        return souscripteur;
    }
    public void setSouscripteur(String souscripteur) {
        this.souscripteur = souscripteur;
    }
    public String getSouscripteurCode() {
        return souscripteurCode;
    }
    public void setSouscripteurCode(String souscripteurCode) {
        this.souscripteurCode = souscripteurCode;
    }
    public String getNewSouscripteur() {
        return newSouscripteur;
    }
    public void setNewSouscripteur(String newSouscripteur) {
        this.newSouscripteur = newSouscripteur;
    }
    
    

    }
