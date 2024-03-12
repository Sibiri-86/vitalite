package com.vitalite.vitalite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitalite.vitalite.implement.GestionImp;
import com.vitalite.vitalite.model.DossierClientDto;


@Service
public class GestionService {
  
     @Autowired
    private GestionImp gestionImp;

    public DossierClientDto createDossierClient(DossierClientDto dossierClientDto) {
        return gestionImp.createDossierClient(dossierClientDto);
    }

    public DossierClientDto updateDossierClient(DossierClientDto dossierClientDto) {
        return gestionImp.updateDossierClient(dossierClientDto);
    }

    public List<DossierClientDto> findDossierClients() {
        return gestionImp.findDossierClients();
    }

   
}
