package com.vitalite.vitalite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitalite.vitalite.implement.GestionImp;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.PrestationDto;
import com.vitalite.vitalite.model.SoinDto;


@Service
public class GestionService {
  
     @Autowired
    private GestionImp gestionImp;

    public DossierClientDto createDossierClient(DossierClientDto dossierClientDto) {
        System.out.println("dossierClientDto 1 ===>" + dossierClientDto);
        return gestionImp.createDossierClient(dossierClientDto);
    }

    public DossierClientDto updateDossierClient(DossierClientDto dossierClientDto) {
        System.out.println("dossierClientDto update 1===>" + dossierClientDto);
        return gestionImp.updateDossierClient(dossierClientDto);
    }

    public List<DossierClientDto> findDossierClients() {
        return gestionImp.findDossierClients();
    }


    public SoinDto createSoin(SoinDto soinDto) {
        System.out.println("soinDto 1 ===>" + soinDto);
        return gestionImp.createSoin(soinDto);
    }

    public SoinDto updateSoin(SoinDto soinDto) {
        System.out.println("soinDto update 1===>" + soinDto);
        return gestionImp.updateSoin(soinDto);
    }

    public List<SoinDto> findSoins() {
        return gestionImp.findSoins();
    }

    public ConventionDto createConvention(ConventionDto conventionDto) {
        return gestionImp.createConvention(conventionDto);
    }

    public ConventionDto updateConvention(ConventionDto conventionDto) {
        return gestionImp.updateConvention(conventionDto);
    }

    public List<ConventionDto> findConventions() {
        return gestionImp.findConventions();
    }
   
    public List<ActeDto> findByConvention(Long conventionId) {
        return gestionImp.findByConvention(conventionId);
    }

}
