package com.vitalite.vitalite.implement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Acte;
import com.vitalite.vitalite.entities.Convention;
import com.vitalite.vitalite.entities.ConventionActe;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.entities.Prestation;
import com.vitalite.vitalite.entities.Soin;
import com.vitalite.vitalite.entities.Taux;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.PrestationDto;
import com.vitalite.vitalite.model.SoinDto;
import com.vitalite.vitalite.model.TauxDto;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.ConventionActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.repository.ActeRepository;
import com.vitalite.vitalite.repository.ConventionActeRepository;
import com.vitalite.vitalite.repository.ConventionRepository;
import com.vitalite.vitalite.repository.DossierClientRepository;
import com.vitalite.vitalite.repository.PrestationRepository;
import com.vitalite.vitalite.repository.ProduitRepository;
import com.vitalite.vitalite.repository.SoinRepository;
import com.vitalite.vitalite.repository.TauxRepository;

@Component
public class GestionImp {
    @Autowired
     private DossierClientRepository dossierClientRepository;
     
     @Autowired
     private PrestationRepository prestationRepository;

     @Autowired
     private SoinRepository soinRepository;
     
     @Autowired
     private Mapper mapper;
     @Autowired
     private ConventionRepository conventionRepository;
     @Autowired
     private ConventionActeRepository conventionActeRepository;
     @Autowired
     private TauxRepository tauxRepository;
    
    @Autowired
     private ActeRepository acteRepository;

     public DossierClientDto createDossierClient(DossierClientDto dossierClientDto){
     
      
      dossierClientDto.setNumDossier(generateNumero(String.valueOf(dossierClientRepository.findAll().size())));
      DossierClient dt = mapper.map(dossierClientDto, DossierClient.class);
      if(dossierClientDto.getTaux() != null && dossierClientDto.getTaux() != BigDecimal.ZERO) {

         Taux taux = new Taux();
         taux.setTauxPourcentage(dossierClientDto.getTaux());
         Taux tauxF = tauxRepository.save(taux);
        
         dt.setTaux(tauxF);
         
      }
      dossierClientRepository.save(dt);
         
         return dossierClientDto;
     }
     
     
     public DossierClientDto updateDossierClient(DossierClientDto dossierClientDto) {
      System.out.println("dossierClientDto update 2===>" + dossierClientDto);
      DossierClient dt = mapper.map(dossierClientDto, DossierClient.class);
        dossierClientRepository.save(dt);
         
         return dossierClientDto;
     }

     public List<DossierClientDto> findDossierClients() {
        return dossierClientRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, DossierClientDto.class)).collect(Collectors.toList());
     }


     public SoinDto createSoin(SoinDto soinDto){
      System.out.println("soinDto 2 ===>" + soinDto);
      soinDto.setNumSoin(generateNumero(String.valueOf(soinRepository.findAll().size())));
      Soin dt = soinRepository.save(mapper.map(soinDto, Soin.class));
        if(soinDto.getPrestations() !=null && !soinDto.getPrestations().isEmpty()) {

         for(PrestationDto p: soinDto.getPrestations()) {
           Prestation prest = new Prestation();
               prest.setSoin(dt);
               prest.setDateSaisie(p.getDateSaisie());
               prest.setDeleted(false);
               Optional<Acte> a = acteRepository.findById(p.getActeId());
               if(a.isPresent()) {
                  prest.setActe(a.get());
               }
               prest.setMontant(p.getMontant());
               prest.setPrixUnitaire(p.getPrixUnitaire());
               prest.setQuantite(p.getQuantite());
               Optional<DossierClient> d = dossierClientRepository.findById(p.getDossierClientId());
               if(d.isPresent()) {
                  prest.setDossierClient(d.get());
               }
               
               prestationRepository.save(mapper.map(prest, Prestation.class));
         }
      }
         
         return soinDto;
     }
     
     public SoinDto updateSoin(SoinDto soinDto){
      System.out.println("soinDto update 2===>" + soinDto);
      Soin dt = mapper.map(soinDto, Soin.class);
        soinRepository.save(dt);
         
         return soinDto;
     }

     public List<SoinDto> findSoins() {
      List<SoinDto> soinToReturn = new ArrayList<>();
      List<SoinDto> s = soinRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, SoinDto.class)).collect(Collectors.toList());
      if(!s.isEmpty()) {
         for(SoinDto so : s) {
            Optional <DossierClient> d = dossierClientRepository.findById(Long.valueOf(so.getPatient()));
            if(d.isPresent()) {
               so.setPatient(d.get().getNom() +" "+d.get().getPrenom());
            }
            soinToReturn.add(so);
         }
         
      }
        return soinToReturn;
     }

     public List<TauxDto> findTaux() {

      return tauxRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, TauxDto.class)).collect(Collectors.toList());
   }

    

     public List<ActeDto> findByConvention(Long conventionId) {
      List<ActeDto> acteDtos = new ArrayList<>();
      conventionActeRepository.findByConventionIdAndDeletedFalse(conventionId)
      .stream().peek(convActe-> {
         ActeDto  acte = mapper.map(convActe.getActe(), ActeDto.class);
          acte.setMontantConvention(convActe.getMontantConvention());
          acte.setConventionActeId(convActe.getId());
          acteDtos.add(acte);
      }).collect(Collectors.toList());
   return acteDtos;
   }

     public ConventionDto createConvention(ConventionDto conventionDto){
      Convention dt = mapper.map(conventionDto, Convention.class);
      
      Convention convention =  conventionRepository.save(dt);
         if(conventionDto.getActes() !=null && !conventionDto.getActes().isEmpty()) {

            for(ActeDto acte: conventionDto.getActes()) {
               ConventionActe conventionActe = new ConventionActe();
               if(acte.getMontantConvention() !=null) {
                  conventionActe.setActe(mapper.map(acte, Acte.class));
                  conventionActe.setConvention(convention);
                  conventionActe.setMontantConvention(acte.getMontantConvention());
                  conventionActe.setDateEffet(convention.getDateEffet());
                  conventionActeRepository.save(conventionActe);
               }
            }
         }

         return conventionDto;
     }

     public ConventionDto updateConvention(ConventionDto conventionDto){
      Convention dt = mapper.map(conventionDto, Convention.class);
      
      Convention convention =  conventionRepository.save(dt);
         if(conventionDto.getActes() !=null && !conventionDto.getActes().isEmpty()) {

            for(ActeDto acte: conventionDto.getActes()) {
               ConventionActe conventionActe = new ConventionActe();
               if(acte.getMontantConvention() !=null) {
                  if(acte.getConventionActeId() !=null) {
                     conventionActe.setId(acte.getConventionActeId());
                  }
                  conventionActe.setActe(mapper.map(acte, Acte.class));
                  conventionActe.setConvention(convention);
                  conventionActe.setMontantConvention(acte.getMontantConvention());
                  conventionActe.setDateEffet(convention.getDateEffet());
                  conventionActeRepository.save(conventionActe);
               }
            }
         }

         return conventionDto;
     }



     public List<ConventionDto> findConventions() {

      return conventionRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, ConventionDto.class)).collect(Collectors.toList());
   }
     private static String generateNumero ( String keyList ) {
            int taille = keyList.length();
            if(taille==1)
               return "00"+keyList;
            if(taille==2)
               return "0"+keyList;
            if(taille >= 3)
               return keyList;
      return "000";
      }

      public List<ConventionActeDto> findMontantConventionByActeIdAndAssureurId(Long acteId, Long assureurId) {
         System.out.println("dedans 222222"+ acteId+ "   "+assureurId);
         Optional<DossierClient>doc = dossierClientRepository.findById(assureurId);
         System.out.println("doccccccccc " + doc.get());
         List<ConventionActeDto> conv = new ArrayList<>();
            if(doc.isPresent() && doc.get().getAssureur() != null) {
               //System.out.println("dedans 333333  " + doc.get().getAssureur().getId());
               Optional<Convention> c = conventionRepository.findByAssureurIdAndDeletedFalse(doc.get().getAssureur().getId());
                  if(c.isPresent()) {
                     System.out.println("dedans 44444"+ acteId+ "   "+assureurId);
                     Optional<ConventionActe> convention = conventionActeRepository.findByDeletedFalseAndConventionIdAndActeId(c.get().getId(), acteId);
                     if(convention.isPresent()) {
                        System.out.println("dedans 5555"+ acteId+ "   "+assureurId);
                        conv.add(mapper.map(convention.get(), ConventionActeDto.class));
                     }
                  }
            }
         
         return conv;
      }

      public List<PrestationDto> findBySoinId(Long soinId) {
         List<PrestationDto> prestationDtos = new ArrayList<>();
         prestationRepository.findBySoinIdAndDeletedFalse(soinId)
         .stream().peek(convActe-> {
            PrestationDto  prest = mapper.map(convActe, PrestationDto.class);
            prest.setActeId(convActe.getActe().getId());
            prest.setDateSaisie(convActe.getDateSaisie());
            prest.setMontant(convActe.getMontant());
            prest.setPrixUnitaire(convActe.getPrixUnitaire());
            prest.setQuantite(convActe.getQuantite());
            prest.setSoinId(soinId);
            prestationDtos.add(prest);
         }).collect(Collectors.toList());
      return prestationDtos;
      }

}
