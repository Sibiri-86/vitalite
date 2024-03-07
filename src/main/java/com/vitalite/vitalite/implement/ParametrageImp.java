package com.vitalite.vitalite.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Acte;
import com.vitalite.vitalite.entities.Assureur;
import com.vitalite.vitalite.entities.Categorie;
import com.vitalite.vitalite.entities.Chambre;
import com.vitalite.vitalite.entities.Examen;
import com.vitalite.vitalite.entities.Produit;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.AssureurDto;
import com.vitalite.vitalite.model.CategorieDto;
import com.vitalite.vitalite.model.ChambreDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.ProduitDto;
import com.vitalite.vitalite.repository.ActeRepository;
import com.vitalite.vitalite.repository.AssureurRepository;
import com.vitalite.vitalite.repository.CategorieRepository;
import com.vitalite.vitalite.repository.ChambreRepository;
import com.vitalite.vitalite.repository.ExamenRepository;
import com.vitalite.vitalite.repository.ProduitRepository;

@Component
public class ParametrageImp {
    @Autowired
     private AssureurRepository assureurRepository;
     @Autowired
     private Mapper mapper;
     @Autowired
     private ActeRepository  acteRepository;
     @Autowired
     private CategorieRepository categorieRepository;
     @Autowired
     private ChambreRepository chambreRepository;
     @Autowired
     private ExamenRepository examenRepository;
     @Autowired
     private ProduitRepository produitRepository;

     public AssureurDto createAssureur(AssureurDto assureurDto){
        Assureur dt = mapper.map(assureurDto, Assureur.class);
        assureurRepository.save(dt);
         
         return assureurDto;
     }
     
     public AssureurDto updateAssureur(AssureurDto assureurDto){
        Assureur dt = mapper.map(assureurDto, Assureur.class);
        assureurRepository.save(dt);
         
         return assureurDto;
     }

     public List<AssureurDto> findAssureurs() {

        return assureurRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, AssureurDto.class)).collect(Collectors.toList());
     }

     public ActeDto createActe(ActeDto acteDto){
        Acte dt = mapper.map(acteDto, Acte.class);
        acteRepository.save(dt);
         
         return acteDto;
     }
     
     public ActeDto updateActe(ActeDto acteDto){
        Acte dt = mapper.map(acteDto, Acte.class);
        acteRepository.save(dt);
         
         return acteDto;
     }

     public List<ActeDto> findActes() {

        return acteRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, ActeDto.class)).collect(Collectors.toList());
     }

     public CategorieDto createCategorie(CategorieDto categorieDto){
        Categorie dt = mapper.map(categorieDto, Categorie.class);
        categorieRepository.save(dt);
         
         return categorieDto;
     }
     
     public CategorieDto updateCategorie(CategorieDto categorieDto){
        Categorie dt = mapper.map(categorieDto, Categorie.class);
        categorieRepository.save(dt);
         
         return categorieDto;
     }

     public List<CategorieDto> findCategories() {

        return categorieRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, CategorieDto.class)).collect(Collectors.toList());
     }
     
     public ChambreDto createChambre(ChambreDto chambreDto){
        Chambre dt = mapper.map(chambreDto, Chambre.class);
        chambreRepository.save(dt);
         
         return chambreDto;
     }
     
     public ChambreDto updateChambre(ChambreDto chambreDto){
        Chambre dt = mapper.map(chambreDto, Chambre.class);
        chambreRepository.save(dt);
         
         return chambreDto;
     }

     public List<ChambreDto> findChambres() {

        return chambreRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, ChambreDto.class)).collect(Collectors.toList());
     }

     public ExamenDto createExamen(ExamenDto examenDto){
        Examen dt = mapper.map(examenDto, Examen.class);
        examenRepository.save(dt);
         return examenDto;
     }
     
     public ExamenDto updateExamen(ExamenDto examenDto){
        Examen dt = mapper.map(examenDto, Examen.class);
        examenRepository.save(dt);
         
         return examenDto;
     }

     public List<ExamenDto> findExamens() {

        return examenRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, ExamenDto.class)).collect(Collectors.toList());
     }

     public List<ExamenDto> findExamenByCategorie(Long categorieId) {

        return examenRepository.findByCategorieIdAndDeletedFalse(categorieId).stream().map(ass->mapper.map(ass, ExamenDto.class)).collect(Collectors.toList());
     }

     public ProduitDto createProduit(ProduitDto produitDto){
        Produit dt = mapper.map(produitDto, Produit.class);
        produitRepository.save(dt);
         
         return produitDto;
     }
     
     public ProduitDto updateProduit(ProduitDto produitDto){
        Produit dt = mapper.map(produitDto, Produit.class);
        produitRepository.save(dt);
         
         return produitDto;
     }

     public List<ProduitDto> findProduits() {

        return produitRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, ProduitDto.class)).collect(Collectors.toList());
     }

}
