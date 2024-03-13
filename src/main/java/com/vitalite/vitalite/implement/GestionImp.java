package com.vitalite.vitalite.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Acte;
import com.vitalite.vitalite.entities.Convention;
import com.vitalite.vitalite.entities.ConventionActe;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.repository.ConventionActeRepository;
import com.vitalite.vitalite.repository.ConventionRepository;
import com.vitalite.vitalite.repository.DossierClientRepository;

@Component
public class GestionImp {
    @Autowired
     private DossierClientRepository dossierClientRepository;
     @Autowired
     private Mapper mapper;
     @Autowired
     private ConventionRepository conventionRepository;
     @Autowired
     private ConventionActeRepository conventionActeRepository;
    

     public DossierClientDto createDossierClient(DossierClientDto dossierClientDto){
      dossierClientDto.setNumDossier(generateNumero(String.valueOf(dossierClientRepository.findAll().size())));
      DossierClient dt = mapper.map(dossierClientDto, DossierClient.class);
        dossierClientRepository.save(dt);
         
         return dossierClientDto;
     }
     
     
     public DossierClientDto updateDossierClient(DossierClientDto dossierClientDto){
      DossierClient dt = mapper.map(dossierClientDto, DossierClient.class);
        dossierClientRepository.save(dt);
         
         return dossierClientDto;
     }

     public List<DossierClientDto> findDossierClients() {

        return dossierClientRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, DossierClientDto.class)).collect(Collectors.toList());
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

}
