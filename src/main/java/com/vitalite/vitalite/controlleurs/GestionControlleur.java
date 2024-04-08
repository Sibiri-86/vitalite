package com.vitalite.vitalite.controlleurs;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.ConventionActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.PatientDto;
import com.vitalite.vitalite.model.PrestationDto;
import com.vitalite.vitalite.model.SearchDto;
import com.vitalite.vitalite.model.SoinDto;
import com.vitalite.vitalite.model.TauxDto;
import com.vitalite.vitalite.services.GestionService;


@RestController
@RequestMapping("/api")
public class GestionControlleur {
    

    @Autowired
    private GestionService gestionService;
    
    @PostMapping("/dossier-clients")
    public ResponseEntity<DossierClientDto> createDossierClient(@RequestBody final DossierClientDto dossierClientDto) { 
        System.out.println("dossierClientDto===>" + dossierClientDto);
        return new ResponseEntity<>(gestionService.createDossierClient(dossierClientDto), HttpStatus.CREATED);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientDto> createPatient(@RequestBody final PatientDto patientDto) { 
        return new ResponseEntity<>(gestionService.createPatient(patientDto), HttpStatus.CREATED);
    }
    @PutMapping("/patients")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody final PatientDto patientDto) { 
        return new ResponseEntity<>(gestionService.updatePatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> findPatients() { 
        return new ResponseEntity<>(gestionService.findPatients(), HttpStatus.CREATED);
    }

    @GetMapping("/patients/prestation")
    public ResponseEntity<List<PrestationDto>> findPrestationByPatient(@RequestParam Long patientId) { 
        return new ResponseEntity<>(gestionService.findPrestationByPatient(patientId), HttpStatus.CREATED);
    }

    @PutMapping(path = "/patients/prestation")
    public void deletePrestation(@RequestBody final PrestationDto prestationDto){
        gestionService.deletePrestation(prestationDto);
    }
    
    @PutMapping("/dossier-clients")
    public ResponseEntity<DossierClientDto> updateDossierClient(@RequestBody final DossierClientDto dossierClientDto) {
        System.out.println("dossierClientDto===>" + dossierClientDto);   
        return new ResponseEntity<>(gestionService.updateDossierClient(dossierClientDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/dossier-clients")
    public ResponseEntity<List<DossierClientDto>> getAllDossierClient() {
           return  new ResponseEntity<>(gestionService.findDossierClients(), HttpStatus.CREATED);
    }

   

    @PutMapping("/dossier-clients/by-periode")
    public ResponseEntity<List<DossierClientDto>> findDossierClientsByPeriode(@RequestBody final SearchDto searchDto) {
        System.out.println(searchDto);
           return  new ResponseEntity<>(gestionService.findDossierClientsByPeriode(searchDto.getDatD(),searchDto.getDatF()), HttpStatus.CREATED);
    }


    @PostMapping("/soins")
    public ResponseEntity<SoinDto> createSoin(@RequestBody final SoinDto soinDto) { 
        System.out.println("soinDto===>" + soinDto);
        return new ResponseEntity<>(gestionService.createSoin(soinDto), HttpStatus.CREATED);
    }

    
    @PutMapping("/soins")
    public ResponseEntity<SoinDto> updateSoin(@RequestBody final SoinDto soinDto) {
        System.out.println("soinDto===>" + soinDto);   
        return new ResponseEntity<>(gestionService.updateSoin(soinDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/soins")
    public ResponseEntity<List<SoinDto>> getAllSoin() {
           return  new ResponseEntity<>(gestionService.findSoins(), HttpStatus.CREATED);
    }

    @PostMapping("/conventions")
    public ResponseEntity<ConventionDto> createDossierClient(@RequestBody final ConventionDto conventionDto) { 

        return new ResponseEntity<>(gestionService.createConvention(conventionDto), HttpStatus.CREATED);
    }

    @PutMapping("/conventions")
    public ResponseEntity<ConventionDto> updateConvention(@RequestBody final ConventionDto conventionDto) { 

        return new ResponseEntity<>(gestionService.updateConvention(conventionDto), HttpStatus.CREATED);
    }

    @GetMapping("/conventions")
    public ResponseEntity<List<ConventionDto>> getAllConventions() {
           return  new ResponseEntity<>(gestionService.findConventions(), HttpStatus.CREATED);
    }
    @GetMapping("/conventions/by-convention")
    public ResponseEntity<List<SousActeDto>> findByConvention(@RequestParam Long conventionId) {
           return  new ResponseEntity<>(gestionService.findByConvention(conventionId), HttpStatus.CREATED);
    }

    @GetMapping("conventions/convention-by-acte")
    public ResponseEntity<List<ConventionActeDto>> findMontantConventionByActeIdAndAssureurId(@RequestParam Long acteId, @RequestParam Long assureurId) {
           return  new ResponseEntity<>(gestionService.findMontantConventionByActeIdAndAssureurId(acteId, assureurId), HttpStatus.CREATED);
    }

    @GetMapping("soins/by-soin")
    public ResponseEntity<List<PrestationDto>> findBySoinId(@RequestParam Long soinId) {
           return  new ResponseEntity<>(gestionService.findBySoinId(soinId), HttpStatus.CREATED);
    }

    
   
    @GetMapping("/dossier-clients/by-taux")
    public ResponseEntity<List<TauxDto>> getAllTaux() {
           return  new ResponseEntity<>(gestionService.findTaux(), HttpStatus.CREATED);
    }
}
