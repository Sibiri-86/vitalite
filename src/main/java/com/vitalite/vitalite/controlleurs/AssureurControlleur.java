package com.vitalite.vitalite.controlleurs;


import java.math.BigDecimal;
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
import org.springframework.web.multipart.MultipartFile;

import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.SouscripteurDto;
import com.vitalite.vitalite.entities.Pharmacie;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.AssureurDto;
import com.vitalite.vitalite.model.CategorieDto;
import com.vitalite.vitalite.model.ChambreDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.FamilleActeDto;
import com.vitalite.vitalite.model.PharmacieDto;
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

    @PutMapping("/familleActes/delete")
    public ResponseEntity<FamilleActeDto> deleteFamilleActe(@RequestBody final FamilleActeDto acteDto) { 
        return new ResponseEntity<>(parametrageService.deleteFamilleActe(acteDto), HttpStatus.CREATED);
    }
    
    @GetMapping("familleActes")
    public ResponseEntity<List<FamilleActeDto>> getAllFamilleActe() {
           return  new ResponseEntity<>(parametrageService.finFamilleActes(), HttpStatus.CREATED);
    }


    @PostMapping("/pharmacies")
    public ResponseEntity<PharmacieDto> createPharmacie(@RequestBody final PharmacieDto acteDto) { 

        return new ResponseEntity<>(parametrageService.createPharmacie(acteDto), HttpStatus.CREATED);
    }

    @PutMapping("/pharmacies")
    public ResponseEntity<PharmacieDto> updatePharmacie(@RequestBody final PharmacieDto acteDto) { 
        return new ResponseEntity<>(parametrageService.updatePharmacie(acteDto), HttpStatus.CREATED);
    }

    @PutMapping("/pharmacies/delete")
    public ResponseEntity<PharmacieDto> deletePharmacie(@RequestBody final PharmacieDto acteDto) { 
        return new ResponseEntity<>(parametrageService.deletePharmacie(acteDto), HttpStatus.CREATED);
    }
    
    @GetMapping("pharmacies")
    public ResponseEntity<List<PharmacieDto>> getAllPharmacie() {
           return  new ResponseEntity<>(parametrageService.finPharmacies(), HttpStatus.CREATED);
    }


    @GetMapping("pharmacies/by-sous-acte/{sousActeId}")
    public ResponseEntity<List<PharmacieDto>> findPharmaciesBySousActe(@PathVariable Long sousActeId) {
           return  new ResponseEntity<>(parametrageService.findPharmaciesBySousActe(sousActeId), HttpStatus.CREATED);
    }

    @GetMapping("pharmacies/by-sous-acte-code/{sousActeCode}")
    public ResponseEntity<List<PharmacieDto>> findPharmaciesBySousActeCode(@PathVariable String sousActeCode) {
           return  new ResponseEntity<>(parametrageService.findPharmaciesBySousActeCode(sousActeCode), HttpStatus.CREATED);
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

    @PutMapping("/actes/delete")
    public ResponseEntity<ActeDto> deleteActe(@RequestBody final ActeDto dto) { 

        return new ResponseEntity<>(parametrageService.deleteActe(dto), HttpStatus.CREATED);
    }
    @GetMapping("actes/by-famille-acte")
    public ResponseEntity<List<ActeDto>> findActesByFamilleActe(@RequestParam Long famillleActeId) {
           return  new ResponseEntity<>(parametrageService.findActesByFamilleActe(famillleActeId), HttpStatus.CREATED);
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

    @PutMapping("/sousActes/delete")
    public ResponseEntity<SousActeDto> deleteSousActe(@RequestBody final SousActeDto dto) { 

        return new ResponseEntity<>(parametrageService.deleteSousActe(dto), HttpStatus.CREATED);
    }
    @GetMapping("sousActes/by-acte")
    public ResponseEntity<List<SousActeDto>> finASousctesByActe(@RequestParam Long acteId) {
        System.out.println("====================oui====="+acteId);
           return  new ResponseEntity<>(parametrageService.finASousctesByActe(acteId), HttpStatus.CREATED);
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

    @GetMapping("sousActes/by-montantPrefinancement")
    public ResponseEntity<BigDecimal> findMontantPrefinancement(@RequestParam Long sousActeId) {
        return new ResponseEntity<>(parametrageService.findMontantPrefinancement(sousActeId),  HttpStatus.CREATED);
    }
 
    @GetMapping("sousActes/by-montantConvention")
    public ResponseEntity<BigDecimal> findMontantConvention(@RequestParam Long assureurId, @RequestParam Long sousActeId) {
        return new ResponseEntity<>(parametrageService.findMontantConvention(assureurId, sousActeId),  HttpStatus.CREATED);
    }

    @PostMapping("/souscripteurs")
    public ResponseEntity<SouscripteurDto> createSouscripteur(@RequestBody final SouscripteurDto souscripteurDto) { 

        return new ResponseEntity<>(parametrageService.creaSouscripteur(souscripteurDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/souscripteurs")
    public ResponseEntity<SouscripteurDto> updateSouscripteur(@RequestBody final SouscripteurDto souscripteurDto) {   
        return new ResponseEntity<>(parametrageService.updateSouscripteur(souscripteurDto), HttpStatus.CREATED);
    }

     @PutMapping("/souscripteurs/delete/{id}")
    public ResponseEntity<SouscripteurDto> deleteSouscripteur(@RequestBody final SouscripteurDto souscripteurDto, @PathVariable String id) {
        System.out.println("gggggggggggggg" + souscripteurDto); 
        return new ResponseEntity<>(parametrageService.deleteSouscripteur(souscripteurDto), HttpStatus.CREATED);
    }
    
    @GetMapping("souscripteurs")
    public ResponseEntity<List<SouscripteurDto>> getAllSouscripteur() {
           return  new ResponseEntity<>(parametrageService.finSouscripteur(), HttpStatus.CREATED);
    }
    @PostMapping(path = "/familleActes/upload")
    public ResponseEntity<Boolean> uploadTypeGarantie(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(parametrageService.uploadTypeGarantie(file), HttpStatus.CREATED);
    }

    @PostMapping(path = "/pharmacies/upload")
    public ResponseEntity<Boolean> uploadPharmacie(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(parametrageService.uploadPharmacie(file), HttpStatus.CREATED);
    }

    @PostMapping(path = "/pharmacies/consommable/upload")
    public ResponseEntity<Boolean> uploadConsommable(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(parametrageService.uploadConsommable(file), HttpStatus.CREATED);
    }
    @PostMapping(path = "/actes/upload")
    public ResponseEntity<Boolean> uploadExcelToActe(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(parametrageService.uploadExcelToActe(file), HttpStatus.CREATED);
    }

    @PostMapping(path = "/sousActes/upload")
    public ResponseEntity<Boolean> uploadexcelToSousActe(@RequestParam("file") MultipartFile file){
        return new ResponseEntity<>(parametrageService.uploadexcelToSousActe(file), HttpStatus.CREATED);
    }
}
