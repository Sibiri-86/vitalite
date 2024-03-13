package com.vitalite.vitalite.implement;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.entities.Soin;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.SoinDto;
import com.vitalite.vitalite.repository.DossierClientRepository;
import com.vitalite.vitalite.repository.PrestationRepository;
import com.vitalite.vitalite.repository.SoinRepository;

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
    

     public DossierClientDto createDossierClient(DossierClientDto dossierClientDto){
      System.out.println("dossierClientDto 2 ===>" + dossierClientDto);
      dossierClientDto.setNumDossier(generateNumero(String.valueOf(dossierClientRepository.findAll().size())));
      DossierClient dt = mapper.map(dossierClientDto, DossierClient.class);
        dossierClientRepository.save(dt);
         
         return dossierClientDto;
     }
     
     public DossierClientDto updateDossierClient(DossierClientDto dossierClientDto){
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
      Soin dt = mapper.map(soinDto, Soin.class);
        soinRepository.save(dt);
         
         return soinDto;
     }
     
     public SoinDto updateSoin(SoinDto soinDto){
      System.out.println("soinDto update 2===>" + soinDto);
      Soin dt = mapper.map(soinDto, Soin.class);
        soinRepository.save(dt);
         
         return soinDto;
     }

     public List<SoinDto> findSoins() {

        return soinRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, SoinDto.class)).collect(Collectors.toList());
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
