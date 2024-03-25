package com.vitalite.vitalite.controlleurs;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.AssureurDto;
import com.vitalite.vitalite.model.CategorieDto;
import com.vitalite.vitalite.model.ChambreDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.FamilleActeDto;
import com.vitalite.vitalite.model.ProduitDto;
import com.vitalite.vitalite.model.SocieteDto;
import com.vitalite.vitalite.services.ParametrageService;


@RestController
@RequestMapping("/api")
public class AssureurControlleur {
    

    @Autowired
    private ParametrageService parametrageService;
    
    @PostMapping("/assureurs")
    public ResponseEntity<AssureurDto> createAssureur(@RequestBody final AssureurDto assureurDto) { 

        return new ResponseEntity<>(parametrageService.creaAssureur(assureurDto), HttpStatus.CREATED);
    }

    
    @PutMapping("/assureurs")
    public ResponseEntity<AssureurDto> updateAssureur(@RequestBody final AssureurDto assureurDto) {   
        return new ResponseEntity<>(parametrageService.updateAssureur(assureurDto), HttpStatus.CREATED);
    }

     @PutMapping("/assureurs/delete/{id}")
    public ResponseEntity<AssureurDto> deleteAssureur(@RequestBody final AssureurDto assureurDto, @PathVariable String id) {
        System.out.println("gggggggggggggg" + assureurDto); 
        return new ResponseEntity<>(parametrageService.deleteAssureur(assureurDto), HttpStatus.CREATED);
    }
    
    @GetMapping("assureurs")
    public ResponseEntity<List<AssureurDto>> getAllAssureur() {
           return  new ResponseEntity<>(parametrageService.finAssureur(), HttpStatus.CREATED);
    }

    @PostMapping("/familleActes")
    public ResponseEntity<FamilleActeDto> createFamilleActe(@RequestBody final FamilleActeDto acteDto) { 

        return new ResponseEntity<>(parametrageService.createFamilleActe(acteDto), HttpStatus.CREATED);
    }

    @PutMapping("/familleActes")
    public ResponseEntity<FamilleActeDto> updateFamilleActe(@RequestBody final FamilleActeDto acteDto) {   
        return new ResponseEntity<>(parametrageService.updateFamilleActe(acteDto), HttpStatus.CREATED);
    }
    
    @GetMapping("familleActes")
    public ResponseEntity<List<FamilleActeDto>> getAllFamilleActe() {
           return  new ResponseEntity<>(parametrageService.finFamilleActes(), HttpStatus.CREATED);
    }

    @PostMapping("/actes")
    public ResponseEntity<ActeDto> createActe(@RequestBody final ActeDto acteDto) { 

        return new ResponseEntity<>(parametrageService.createActe(acteDto), HttpStatus.CREATED);
    }

    @PutMapping("/actes")
    public ResponseEntity<ActeDto> updateActe(@RequestBody final ActeDto acteDto) {   
        return new ResponseEntity<>(parametrageService.updateActe(acteDto), HttpStatus.CREATED);
    }
    
    @GetMapping("actes")
    public ResponseEntity<List<ActeDto>> getAllActe() {
           return  new ResponseEntity<>(parametrageService.finActes(), HttpStatus.CREATED);
    }


    @PostMapping("/sousActes")
    public ResponseEntity<SousActeDto> createSousActe(@RequestBody final SousActeDto dto) { 

        return new ResponseEntity<>(parametrageService.createSousActe(dto), HttpStatus.CREATED);
    }

    @PutMapping("/sousActes")
    public ResponseEntity<SousActeDto> updateSousActe(@RequestBody final SousActeDto dto) {   
        return new ResponseEntity<>(parametrageService.updateSousActe(dto), HttpStatus.CREATED);
    }
    
    @GetMapping("sousActes")
    public ResponseEntity<List<SousActeDto>> getAllSousActe() {
           return  new ResponseEntity<>(parametrageService.finASousctes(), HttpStatus.CREATED);
    }

    
    @PostMapping("/categories")
    public ResponseEntity<CategorieDto> createCategorie(@RequestBody final CategorieDto categorieDto) { 

        return new ResponseEntity<>(parametrageService.createCategorie(categorieDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/categories")
    public ResponseEntity<CategorieDto> updateCategorie(@RequestBody final CategorieDto categorieDto) {   
        return new ResponseEntity<>(parametrageService.updateCategorie(categorieDto), HttpStatus.CREATED);
    }
    
    @GetMapping("categories")
    public ResponseEntity<List<CategorieDto>> getAllCategorie() {
           return  new ResponseEntity<>(parametrageService.findCategories(), HttpStatus.CREATED);
    }

    @PostMapping("/chambres")
    public ResponseEntity<ChambreDto> createChambre(@RequestBody final ChambreDto chambreDto) { 

        return new ResponseEntity<>(parametrageService.createChambre(chambreDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/chambres")
    public ResponseEntity<ChambreDto> updateActe(@RequestBody final ChambreDto chambreDto) {   
        return new ResponseEntity<>(parametrageService.updateChambre(chambreDto), HttpStatus.CREATED);
    }
    
    @GetMapping("chambres")
    public ResponseEntity<List<ChambreDto>> getAllChambre() {
           return  new ResponseEntity<>(parametrageService.findChambres(), HttpStatus.CREATED);
    }

    @PostMapping("/examens")
    public ResponseEntity<ExamenDto> createExamen(@RequestBody final ExamenDto examenDto) { 

        return new ResponseEntity<>(parametrageService.createExamen(examenDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/examens")
    public ResponseEntity<ExamenDto> updateExamen(@RequestBody final ExamenDto examenDto) {   
        return new ResponseEntity<>(parametrageService.updateExamen(examenDto), HttpStatus.CREATED);
    }
    
    @GetMapping("examens")
    public ResponseEntity<List<ExamenDto>> getAllExamen() {
           return  new ResponseEntity<>(parametrageService.findExamens(), HttpStatus.CREATED);
    }

    @GetMapping("examens/categorie")
    public ResponseEntity<List<ExamenDto>> getAllExamen(@RequestParam Long categorieId) {
           return  new ResponseEntity<>(parametrageService.findExamenByCategorie(categorieId), HttpStatus.CREATED);
    }

    @PostMapping("/produits")
    public ResponseEntity<ProduitDto> createProduit(@RequestBody final ProduitDto produitDto) { 

        return new ResponseEntity<>(parametrageService.createProduit(produitDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/produits")
    public ResponseEntity<ProduitDto> updateProduit(@RequestBody final ProduitDto produitDto) {   
        return new ResponseEntity<>(parametrageService.updateProduit(produitDto), HttpStatus.CREATED);
    }
    
    @GetMapping("produits")
    public ResponseEntity<List<ProduitDto>> getAllProduit() {
           return  new ResponseEntity<>(parametrageService.findProduits(), HttpStatus.CREATED);
    }


    @PostMapping("/societes")
    public ResponseEntity<SocieteDto> createSociete(@RequestBody final SocieteDto acteDto) { 

        return new ResponseEntity<>(parametrageService.createSociete(acteDto), HttpStatus.CREATED);
    }

    @PutMapping("/societes")
    public ResponseEntity<SocieteDto> updateSociete(@RequestBody final SocieteDto acteDto) {   
        return new ResponseEntity<>(parametrageService.updateSociete(acteDto), HttpStatus.CREATED);
    }
    
    @GetMapping("societes")
    public ResponseEntity<List<SocieteDto>> getAllSociete() {
           return  new ResponseEntity<>(parametrageService.findSocietes(), HttpStatus.CREATED);
    }
}
