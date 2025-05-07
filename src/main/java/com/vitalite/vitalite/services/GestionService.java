package com.vitalite.vitalite.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitalite.vitalite.implement.GestionImp;
import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.SouscripteurDto;
import com.vitalite.vitalite.model.ArreteDto;
import com.vitalite.vitalite.model.ConventionActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.LaboratoireDto;
import com.vitalite.vitalite.model.PatientDto;
import com.vitalite.vitalite.model.PharmacieDto;
import com.vitalite.vitalite.model.PrestationDto;
import com.vitalite.vitalite.model.SearchDto;
import com.vitalite.vitalite.model.SoinDto;
import com.vitalite.vitalite.model.TauxDto;
import com.vitalite.vitalite.model.report.Search;

import net.sf.jasperreports.engine.JRException;


@Service
public class GestionService {
  
     @Autowired
    private GestionImp gestionImp;

    public LaboratoireDto createLabo(LaboratoireDto laboratoireDto) {
        return gestionImp.createLabo(laboratoireDto);
    }
    public LaboratoireDto updateLabo(LaboratoireDto laboratoireDto) {
        return gestionImp.updateLabo(laboratoireDto);
    }

    public List<LaboratoireDto> findLaborations() {
        return gestionImp.findLaborations();
    }

    public PatientDto createPatient(PatientDto patientDto) {
        return gestionImp.createPatient(patientDto);
    }

    public List<PharmacieDto> findByPrestationAndPharmacie(Long prestationId, Long idSousActe) {
        return gestionImp.findByPrestationAndPharmacie(prestationId, idSousActe);
    }

    public PatientDto updatePatient(PatientDto patientDto) {
        return gestionImp.updatePatient(patientDto);
    }

    public void deletePatient(Long idPatient) {
        gestionImp.deletePatient(idPatient);
    }

    public void deleteProduitPrestation(Long idPreP) {
        gestionImp.deleteProduitPrestation(idPreP);
    }

    public void validerPaiement(Long idPatient) {
        gestionImp.validerPaiement(idPatient);
    }

    public void devaliderPaiement(Long idPatient) {
        gestionImp.devaliderPaiement(idPatient);
    }

    public void validerAllPaiement(List<PatientDto> patientDtos) {
        gestionImp.validerAllPaiement(patientDtos);
    }

    
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

    public List<PatientDto> findPatients() {
        return gestionImp.findPatients();
    }


    public List<PatientDto> findPatientsByAssureurAndPeriode(Long assureurId, LocalDate dateD, LocalDate dateF) {
        return gestionImp.findPatientsByAssureurAndPeriode(assureurId, dateD, dateF);
    }

    public List<PatientDto> findPatientsByPeriode( LocalDate dateD, LocalDate dateF) {
        return gestionImp.findPatientsByPeriode(dateD, dateF);
    }

    public ArreteDto findArreteByPeriode( LocalDate dateD, LocalDate dateF) {
        return gestionImp.findArreteByPeriode(dateD, dateF);
    }

    public ArreteDto findFactureByPeriode(Long assureurId, LocalDate dateD, LocalDate dateF) {
        return gestionImp.findFactureByPeriode(assureurId,dateD, dateF);
    }
    public List<PatientDto> findPatientsByLabo() {
        return gestionImp.findPatientsByLabo();
    }

    public List<PrestationDto> findPrestationByPatient(Long patientId) {
        return gestionImp.findByPatients(patientId);
    }

    public List<PrestationDto> findByPatientsAndLabo(Long patientId) {
        return gestionImp.findByPatientsAndLabo(patientId);
    }
    

    public void deletePrestation(PrestationDto prestationDto) {
         gestionImp.deletePrestation(prestationDto);
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
    public List<TauxDto> findTaux() {
        return gestionImp.findTaux();
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
   
    public List<SousActeDto> findByConvention(Long conventionId) {
        return gestionImp.findByConvention(conventionId);
    }

    public void deleteConventionId(Long conventionId) {
         gestionImp.deleteConvention(conventionId);
    }

    public List<ConventionActeDto> findMontantConventionByActeIdAndAssureurId(Long acteId, Long assureurId) {
        System.out.println("dedans 111111"+ acteId+ "   "+assureurId);
        return gestionImp.findMontantConventionByActeIdAndAssureurId(acteId, assureurId);
    }

    public List<PrestationDto> findBySoinId(Long soinId) {
        return gestionImp.findBySoinId(soinId);
    }


    public List<DossierClientDto> findDossierClientsByPeriode(LocalDate dateD, LocalDate dateF) {
      return gestionImp.findDossierClientsByPeriode(dateD, dateF);
   }

   public byte[] generateReportCaisse(Long patientId) throws IOException, JRException{
    return gestionImp.generateReport(patientId);
}

public byte[] generateReportExamen(Long patientId) throws IOException, JRException{
    return gestionImp.generateReportExamen(patientId);
}

public byte[] generateReportFacture(SearchDto search) throws IOException, JRException{
    return gestionImp.generateReportFacture(search);
}
public List<SouscripteurDto> findSouscripteurByAssureurId(SearchDto search) {
    return gestionImp.findSouscripteurByAssureurId(search);
}

public List<PatientDto> findPatientsBetweenDate(LocalDate dateD, LocalDate dateF) {
    return gestionImp.findPatientsBetweenDate(dateD, dateF);
}
}
