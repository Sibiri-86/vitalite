package com.vitalite.vitalite.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.repository.DossierClientRepository;

@Component
public class GestionImp {
    @Autowired
     private DossierClientRepository dossierClientRepository;
     @Autowired
     private Mapper mapper;
    

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
