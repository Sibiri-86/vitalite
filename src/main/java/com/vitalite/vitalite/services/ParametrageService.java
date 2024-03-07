package com.vitalite.vitalite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitalite.vitalite.implement.ParametrageImp;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.AssureurDto;
import com.vitalite.vitalite.model.CategorieDto;
import com.vitalite.vitalite.model.ChambreDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.ProduitDto;

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

    public List<AssureurDto> finAssureur() {
        return parametrageCLientImp.findAssureurs();
    }

    public ActeDto createActe(ActeDto acteDto) {
        return parametrageCLientImp.createActe(acteDto);
    }

    public ActeDto updateActe(ActeDto acteDto) {
        return parametrageCLientImp.updateActe(acteDto);
    }

    public List<ActeDto> finActes() {
        return parametrageCLientImp.findActes();
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

}
