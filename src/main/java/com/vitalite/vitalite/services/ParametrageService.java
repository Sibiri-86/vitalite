package com.vitalite.vitalite.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vitalite.vitalite.entities.Pharmacie;
import com.vitalite.vitalite.implement.ParametrageImp;
import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.SouscripteurDto;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.AssureurDto;
import com.vitalite.vitalite.model.CategorieDto;
import com.vitalite.vitalite.model.ChambreDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.FamilleActeDto;
import com.vitalite.vitalite.model.PharmacieDto;
import com.vitalite.vitalite.model.ProduitDto;
import com.vitalite.vitalite.model.SocieteDto;

@Service
public class ParametrageService {
  
     @Autowired
    private ParametrageImp parametrageCLientImp;

    public AssureurDto creaAssureur(AssureurDto assureurDto) {
        return parametrageCLientImp.createAssureur(assureurDto);
    }

    public AssureurDto updateAssureur(AssureurDto assureurDto) {
        return parametrageCLientImp.updateAssureur(assureurDto);
    }

    public AssureurDto deleteAssureur(AssureurDto assureurDto) {
        return parametrageCLientImp.deleteAssureur(assureurDto);
    }


    public List<AssureurDto> finAssureur() {
        return parametrageCLientImp.findAssureurs();
    }

    public FamilleActeDto createFamilleActe(FamilleActeDto familleActeDto) {
        return parametrageCLientImp.createFamilleActe(familleActeDto);
    }

    public FamilleActeDto updateFamilleActe(FamilleActeDto acteDto) {
        return parametrageCLientImp.updateFamilleActe(acteDto);
    }

    public FamilleActeDto deleteFamilleActe(FamilleActeDto acteDto) {
        return parametrageCLientImp.deleteFamilleActe(acteDto);
    }

    public List<FamilleActeDto> finFamilleActes() {
        return parametrageCLientImp.findFamilleActes();
    }

    public PharmacieDto createPharmacie(PharmacieDto pharmacieDto) {
        return parametrageCLientImp.createPharmacie(pharmacieDto);
    }

    public PharmacieDto updatePharmacie(PharmacieDto pharmacieDto) {
        return parametrageCLientImp.updatePharmacie(pharmacieDto);
    }

    public PharmacieDto deletePharmacie(PharmacieDto pharmacieDto) {
        return parametrageCLientImp.deletePharmacie(pharmacieDto);
    }

    public List<PharmacieDto> finPharmacies() {
        return parametrageCLientImp.findPharmacies();
    }

    public List<PharmacieDto> findPharmaciesBySousActe(Long sousActeId) {
        return parametrageCLientImp.findPharmaciesBySousActe(sousActeId);
    }

    public List<PharmacieDto> findPharmaciesBySousActeCode(String sousActeCode) {
        return parametrageCLientImp.findPharmaciesBySousActeCode(sousActeCode);
    }

    public ActeDto createActe(ActeDto acteDto) {
        return parametrageCLientImp.createActe(acteDto);
    }

    public ActeDto updateActe(ActeDto acteDto) {
        return parametrageCLientImp.updateActe(acteDto);
    }
    public ActeDto deleteActe(ActeDto dto) {
        return parametrageCLientImp.deleteActe(dto);
    }

    public List<ActeDto> finActes() {
        return parametrageCLientImp.findActes();
    }

    public SousActeDto createSousActe(SousActeDto acteDto) {
        return parametrageCLientImp.createSousActe(acteDto);
    }

    public SousActeDto updateSousActe(SousActeDto acteDto) {
        return parametrageCLientImp.updateSousActe(acteDto);
    }

    public SousActeDto deleteSousActe(SousActeDto dto) {
        return parametrageCLientImp.deleteSousActe(dto);
    }

    public List<SousActeDto> finASousctes() {
        return parametrageCLientImp.findSousActes();
    }

    public List<SousActeDto> finASousctesByActe(Long acteId) {
        return parametrageCLientImp.findSousActesByActId(acteId);
    }

    public List<ActeDto> findActesByFamilleActe(Long familleActeId) {
        return parametrageCLientImp.findActeByFamilleId(familleActeId);
    }


    public CategorieDto createCategorie(CategorieDto categorieDto) {
        return parametrageCLientImp.createCategorie(categorieDto);
    }

    public CategorieDto updateCategorie(CategorieDto categorieDto) {
        return parametrageCLientImp.updateCategorie(categorieDto);
    }

    public List<CategorieDto> findCategories() {
        return parametrageCLientImp.findCategories();
    }


    public ChambreDto createChambre(ChambreDto chambreDto) {
        return parametrageCLientImp.createChambre(chambreDto);
    }

    public ChambreDto updateChambre(ChambreDto chambreDto) {
        return parametrageCLientImp.updateChambre(chambreDto);
    }

    public List<ChambreDto> findChambres() {
        return parametrageCLientImp.findChambres();
    }

    public ExamenDto createExamen(ExamenDto examenDto) {
        return parametrageCLientImp.createExamen(examenDto);
    }

    public ExamenDto updateExamen(ExamenDto examenDto) {
        return parametrageCLientImp.updateExamen(examenDto);
    }

    public List<ExamenDto> findExamens() {
        return parametrageCLientImp.findExamens();
    }

    public List<ExamenDto> findExamenByCategorie(Long categorieId) {
        return parametrageCLientImp.findExamenByCategorie(categorieId);
    }
    public ProduitDto createProduit(ProduitDto produitDto) {
        return parametrageCLientImp.createProduit(produitDto);
    }

    public ProduitDto updateProduit(ProduitDto produitDto) {
        return parametrageCLientImp.updateProduit(produitDto);
    }

    public List<ProduitDto> findProduits() {
        return parametrageCLientImp.findProduits();
    }

    public SocieteDto createSociete(SocieteDto acteDto) {
        return parametrageCLientImp.createSociete(acteDto);
    }

    public SocieteDto updateSociete(SocieteDto acteDto) {
        return parametrageCLientImp.updateSociete(acteDto);
    }

    public List<SocieteDto> findSocietes() {
        return parametrageCLientImp.findSocietes();
    }

    public BigDecimal findMontantPrefinancement(Long sousActeId) {
        return parametrageCLientImp.findMontantPrefinancement(sousActeId);
    }
 
    public BigDecimal findMontantConvention(Long assureurId,Long sousActeId) {
        return parametrageCLientImp.findMontantConvention(assureurId, sousActeId);
    }

    public SouscripteurDto creaSouscripteur(SouscripteurDto souscripteurDto) {
        return parametrageCLientImp.createSouscripteur(souscripteurDto);
    }

    public SouscripteurDto updateSouscripteur(SouscripteurDto souscripteurDto) {
        return parametrageCLientImp.updateSouscripteur(souscripteurDto);
    }

    public SouscripteurDto deleteSouscripteur(SouscripteurDto souscripteurDto) {
        return parametrageCLientImp.deleteSouscripteur(souscripteurDto);
    }


    public List<SouscripteurDto> finSouscripteur() {
        return parametrageCLientImp.findSouscripteurs();
    }
    public Boolean uploadPharmacie(MultipartFile file) {
        return parametrageCLientImp.uploadPharmacie(file);
     }

     public Boolean uploadConsommable(MultipartFile file) {
        return parametrageCLientImp.uploadConsommable(file);
     }

    public Boolean uploadTypeGarantie(MultipartFile file) {
       return parametrageCLientImp.uploadTypeGarantie(file);
    }

    public Boolean uploadExcelToActe(MultipartFile file) {
        return parametrageCLientImp.uploadExcelToActe(file);
     }

     public Boolean uploadexcelToSousActe(MultipartFile file) {
        return parametrageCLientImp.uploadexcelToSousActe(file);
     }


}
