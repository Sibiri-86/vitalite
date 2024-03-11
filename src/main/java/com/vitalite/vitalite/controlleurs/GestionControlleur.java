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
import org.springframework.web.bind.annotation.RestController;


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

   
}
