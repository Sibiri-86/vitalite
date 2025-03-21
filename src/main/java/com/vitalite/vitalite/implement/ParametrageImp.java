package com.vitalite.vitalite.implement;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Acte;
import com.vitalite.vitalite.entities.Assureur;
import com.vitalite.vitalite.entities.Categorie;
import com.vitalite.vitalite.entities.Chambre;
import com.vitalite.vitalite.entities.ConventionActe;
import com.vitalite.vitalite.entities.Examen;
import com.vitalite.vitalite.entities.FamilleActe;
import com.vitalite.vitalite.entities.Produit;
import com.vitalite.vitalite.entities.Societe;
import com.vitalite.vitalite.entities.SousActe;
import com.vitalite.vitalite.entities.Souscripteur;
import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.SouscripteurDto;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.AssureurDto;
import com.vitalite.vitalite.model.CategorieDto;
import com.vitalite.vitalite.model.ChambreDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.FamilleActeDto;
import com.vitalite.vitalite.model.ProduitDto;
import com.vitalite.vitalite.model.SocieteDto;
import com.vitalite.vitalite.repository.ActeRepository;
import com.vitalite.vitalite.repository.AssureurRepository;
import com.vitalite.vitalite.repository.CategorieRepository;
import com.vitalite.vitalite.repository.ChambreRepository;
import com.vitalite.vitalite.repository.ConventionActeRepository;
import com.vitalite.vitalite.repository.ExamenRepository;
import com.vitalite.vitalite.repository.FamilleActeRepository;
import com.vitalite.vitalite.repository.ProduitRepository;
import com.vitalite.vitalite.repository.SocieteRepository;
import com.vitalite.vitalite.repository.SousActeRepository;
import com.vitalite.vitalite.repository.SouscripteurRepository;
import com.vitalite.vitalite.utilitaire.ExcelAdherentHelper;

@Component
public class ParametrageImp {
    @Autowired
     private AssureurRepository assureurRepository;
     @Autowired
     private SouscripteurRepository souscripteurRepository;
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
     @Autowired
     private FamilleActeRepository familleActeRepository;
     @Autowired
     private SousActeRepository sousActeRepository;

     @Autowired
     private SocieteRepository  societeRepository;
     @Autowired
     private ConventionActeRepository conventionActeRepository;

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

     public AssureurDto deleteAssureur(AssureurDto assureurDto) {
      Assureur dt = mapper.map(assureurDto, Assureur.class);
      dt.setDeleted(true);
      assureurRepository.save(dt);
       
       return assureurDto;
     }

     public List<AssureurDto> findAssureurs() {

      return assureurRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, AssureurDto.class)).collect(Collectors.toList());
   }


   public SouscripteurDto createSouscripteur(SouscripteurDto souscripteurDto){
      Souscripteur dt = mapper.map(souscripteurDto, Souscripteur.class);
      souscripteurRepository.save(dt);
       
       return souscripteurDto;
   }
   
   public SouscripteurDto updateSouscripteur(SouscripteurDto souscripteurDto){
      Souscripteur dt = mapper.map(souscripteurDto, Souscripteur.class);
      souscripteurRepository.save(dt);
       
       return souscripteurDto;
   }

   public SouscripteurDto deleteSouscripteur(SouscripteurDto souscripteurDto) {
      Souscripteur dt = mapper.map(souscripteurDto, Souscripteur.class);
    dt.setDeleted(true);
    souscripteurRepository.save(dt);
     
     return souscripteurDto;
   }

   public List<SouscripteurDto> findSouscripteurs() {

    return souscripteurRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, SouscripteurDto.class)).collect(Collectors.toList());
 }

     public FamilleActeDto createFamilleActe(FamilleActeDto familleActeDto){
      FamilleActe dt = mapper.map(familleActeDto, FamilleActe.class);
      familleActeRepository.save(dt);
       
       return familleActeDto;
   }
   
   public FamilleActeDto updateFamilleActe(FamilleActeDto familleActeDto){
      FamilleActe dt = mapper.map(familleActeDto, FamilleActe.class);
      familleActeRepository.save(dt);
       
       return familleActeDto;
   }

   public FamilleActeDto deleteFamilleActe(FamilleActeDto familleActeDto){
    FamilleActe dt = mapper.map(familleActeDto, FamilleActe.class);
    dt.setDeleted(true);
    familleActeRepository.save(dt);
     
     return familleActeDto;
 }

     public List<FamilleActeDto> findFamilleActes() {

        return familleActeRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, FamilleActeDto.class)).collect(Collectors.toList());
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


     public ActeDto deleteActe(ActeDto familleActeDto){
      Acte dt = mapper.map(familleActeDto, Acte.class);
      dt.setDeleted(true);
      acteRepository.save(dt);
       
       return familleActeDto;
   }
   public List<ActeDto> findActes() {

      return acteRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, ActeDto.class)).collect(Collectors.toList());
   }

   public List<ActeDto> findActeByFamilleId(Long familleId) {
      List<ActeDto> acte = new ArrayList<>();
   Optional<FamilleActe> fa = familleActeRepository.findById(familleId);
   if (fa.isPresent()) {
     acte =  acteRepository.findByFamilleActeCodeAndDeletedFalse(fa.get().getCode()).stream().map(ass->mapper.map(ass, ActeDto.class)).collect(Collectors.toList());
   }

   return acte;
   }

     public SousActeDto createSousActe(SousActeDto acteDto){
      SousActe dt = mapper.map(acteDto, SousActe.class);
      sousActeRepository.save(dt);
       
       return acteDto;
   }
   
   public SousActeDto updateSousActe(SousActeDto acteDto){
      SousActe dt = mapper.map(acteDto, SousActe.class);
      Optional<Acte> aaa = acteRepository.findByCodeAndDeletedFalse(acteDto.getActeCode());
            if(aaa.isPresent()) {
               dt.setActe(acteRepository.findByCodeAndDeletedFalse(acteDto.getActeCode()).get());
               dt.setFamilleActe(familleActeRepository.findByCodeAndDeletedFalse(acteRepository.findByCodeAndDeletedFalse(acteDto.getActeCode()).get().getFamilleActeCode()).get());
               if(aaa.get().getIsExamen()) {
                  dt.setIsExamen(Boolean.TRUE);
               }
            }
      sousActeRepository.save(dt);
       
       return acteDto;
   }

   public SousActeDto deleteSousActe(SousActeDto dto){
      SousActe dt = mapper.map(dto, SousActe.class);
      dt.setDeleted(true);
      sousActeRepository.save(dt);
       
       return dto;
   }

   public List<SousActeDto> findSousActes() {

      return sousActeRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, SousActeDto.class)).collect(Collectors.toList());
   }

   public List<SousActeDto> findSousActesByActId(Long acteId) {
      List<SousActeDto> sa = new ArrayList<>();
      Optional<Acte> a = acteRepository.findById(acteId);
      if(a.isPresent()) {
         sa = sousActeRepository.findByActeCodeAndDeletedFalse(a.get().getCode()).stream().map(ass->mapper.map(ass, SousActeDto.class)).collect(Collectors.toList());
      }
      return sa;
   }

   public BigDecimal findMontantPrefinancement(Long sousActeId) {

      BigDecimal montant = new BigDecimal(0);
      Optional<SousActe> sousActe = sousActeRepository.findById(sousActeId);
      if(sousActe.isPresent()) {
         montant = sousActe.get().getPrixActe();
      }
      return montant;
   }


   public BigDecimal findMontantConvention(Long assureurId,Long sousActeId) {

      BigDecimal montantConvention = new BigDecimal(0);
      Optional<ConventionActe> conv = conventionActeRepository.findByDeletedFalseAndConvention_Assureur_IdAndSousActeId(assureurId, sousActeId);
      if(conv.isPresent()) {
         montantConvention = conv.get().getMontantConvention();
      }
      return montantConvention;
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

     public SocieteDto createSociete(SocieteDto acteDto){
      Societe dt = mapper.map(acteDto, Societe.class);
      societeRepository.save(dt);
       
       return acteDto;
   }
   
   public SocieteDto updateSociete(SocieteDto acteDto){
      Societe dt = mapper.map(acteDto, Societe.class);
      societeRepository.save(dt);
       
       return acteDto;
   }

   public List<SocieteDto> findSocietes() {

      return societeRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, SocieteDto.class)).collect(Collectors.toList());
   }

   public Boolean uploadTypeGarantie(MultipartFile file){
     if(!ExcelAdherentHelper.hasExcelFormat(file)){
      throw new ResponseStatusException(HttpStatus.CONFLICT, "veillez charger un fichier excell");
     }
     try {
      List<FamilleActeDto> dtoList = ExcelAdherentHelper.excelToFamilleActe(file.getInputStream());
      for(FamilleActeDto a: dtoList) {
         FamilleActe acte = mapper.map(a, FamilleActe.class);
         //if(acte.getCode())
         familleActeRepository.save(acte);
       }
      //familleActeRepository.saveAll(dtoList.stream().map(c->mapper.map(c, FamilleActe.class)).collect(Collectors.toList()));
     } catch (IOException e) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "fail to store excel data: " + e.getMessage());
     }
      return Boolean.TRUE;
     }

     public Boolean uploadExcelToActe(MultipartFile file){
      if(!ExcelAdherentHelper.hasExcelFormat(file)){
       throw new ResponseStatusException(HttpStatus.CONFLICT, "veillez charger un fichier excell");
      }
      try {
       List<ActeDto> dtoList = ExcelAdherentHelper.excelToActe(file.getInputStream());
       for(ActeDto a: dtoList) {
         Acte acte = mapper.map(a, Acte.class);
         System.out.println("lllllllllllllllllllllllllll "+ familleActeRepository.findByCodeAndDeletedFalse(a.getFamilleActeCode()).get().getCode());
         acte.setFamilleActe(familleActeRepository.findByCodeAndDeletedFalse(a.getFamilleActeCode()).get());
         acteRepository.save(acte);
       }
       //acteRepository.saveAll(dtoList.stream().map(c->mapper.map(c, Acte.class)).collect(Collectors.toList()));
      } catch (IOException e) {
       throw new ResponseStatusException(HttpStatus.CONFLICT, "fail to store excel data: " + e.getMessage());
      }
       return Boolean.TRUE;
      }

      public Boolean uploadexcelToSousActe(MultipartFile file){
         if(!ExcelAdherentHelper.hasExcelFormat(file)){
          throw new ResponseStatusException(HttpStatus.CONFLICT, "veillez charger un fichier excell");
         }
         try {
          List<SousActeDto> dtoList = ExcelAdherentHelper.excelToSousActe(file.getInputStream());
          for(SousActeDto a: dtoList) {
            SousActe sousActe = mapper.map(a, SousActe.class);
            //System.out.println("lllllllllllllllllllllllllll "+acteRepository.findByCodeAndDeletedFalse(a.getActeCode()).get().getCode());
            Optional<Acte> aaa = acteRepository.findByCodeAndDeletedFalse(a.getActeCode());
            if(aaa.isPresent()) {
               sousActe.setActe(acteRepository.findByCodeAndDeletedFalse(a.getActeCode()).get());
               sousActe.setFamilleActe(familleActeRepository.findByCodeAndDeletedFalse(acteRepository.findByCodeAndDeletedFalse(a.getActeCode()).get().getFamilleActeCode()).get());
               if(aaa.get().getIsExamen()) {
                  sousActe.setIsExamen(Boolean.TRUE);
               }
            }
            System.out.println("lllllllllllllllllllllllllll "+sousActe.getIsExamen());
            sousActeRepository.save(sousActe);
          }
          //sousActeRepository.saveAll(dtoList.stream().map(c->mapper.map(c, SousActe.class)).collect(Collectors.toList()));
         } catch (IOException e) {
          throw new ResponseStatusException(HttpStatus.CONFLICT, "fail to store excel data: " + e.getMessage());
         }
          return Boolean.TRUE;
         }
   

}
