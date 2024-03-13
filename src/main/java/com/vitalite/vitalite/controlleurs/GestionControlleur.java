package com.vitalite.vitalite.controlleurs;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.model.DossierClientDto;

import com.vitalite.vitalite.services.GestionService;


@RestController
@RequestMapping("/api")
public class GestionControlleur {
    

    @Autowired
    private GestionService gestionService;
    
    @PostMapping("/dossier-clients")
    public ResponseEntity<DossierClientDto> createDossierClient(@RequestBody final DossierClientDto dossierClientDto) { 

        return new ResponseEntity<>(gestionService.createDossierClient(dossierClientDto), HttpStatus.CREATED);
    }

    
    @PutMapping("/dossier-clients")
    public ResponseEntity<DossierClientDto> updateDossierClient(@RequestBody final DossierClientDto dossierClientDto) {   
        return new ResponseEntity<>(gestionService.updateDossierClient(dossierClientDto), HttpStatus.CREATED);
    }
    
    @GetMapping("dossier-clients")
    public ResponseEntity<List<DossierClientDto>> getAllDossierClient() {
           return  new ResponseEntity<>(gestionService.findDossierClients(), HttpStatus.CREATED);
    }

    @PostMapping("/conventions")
    public ResponseEntity<ConventionDto> createDossierClient(@RequestBody final ConventionDto conventionDto) { 

        return new ResponseEntity<>(gestionService.createConvention(conventionDto), HttpStatus.CREATED);
    }

    @PutMapping("/conventions")
    public ResponseEntity<ConventionDto> updateConvention(@RequestBody final ConventionDto conventionDto) { 

        return new ResponseEntity<>(gestionService.updateConvention(conventionDto), HttpStatus.CREATED);
    }

    @GetMapping("conventions")
    public ResponseEntity<List<ConventionDto>> getAllConventions() {
           return  new ResponseEntity<>(gestionService.findConventions(), HttpStatus.CREATED);
    }
    @GetMapping("conventions/by-convention")
    public ResponseEntity<List<ActeDto>> findByConvention(@RequestParam Long conventionId) {
           return  new ResponseEntity<>(gestionService.findByConvention(conventionId), HttpStatus.CREATED);
    }
   
}
