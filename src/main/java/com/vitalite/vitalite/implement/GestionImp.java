package com.vitalite.vitalite.implement;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dozermapper.core.Mapper;
import com.ibm.icu.text.RuleBasedNumberFormat;
import com.vitalite.vitalite.entities.Acte;
import com.vitalite.vitalite.entities.Convention;
import com.vitalite.vitalite.entities.ConventionActe;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.entities.Laboratoire;
import com.vitalite.vitalite.entities.Patient;
import com.vitalite.vitalite.entities.Prestation;
import com.vitalite.vitalite.entities.Soin;
import com.vitalite.vitalite.entities.SousActe;
import com.vitalite.vitalite.entities.Taux;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.LaboratoireDto;
import com.vitalite.vitalite.model.PatientDto;
import com.vitalite.vitalite.model.PrestationDto;
import com.vitalite.vitalite.model.SoinDto;
import com.vitalite.vitalite.model.TauxDto;
import com.vitalite.vitalite.model.report.Caisse;
import com.vitalite.vitalite.model.report.CaisseList;
import com.vitalite.vitalite.model.SousActeDto;
import com.vitalite.vitalite.model.ConventionActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.repository.ActeRepository;
import com.vitalite.vitalite.repository.ConventionActeRepository;
import com.vitalite.vitalite.repository.ConventionRepository;
import com.vitalite.vitalite.repository.DossierClientRepository;
import com.vitalite.vitalite.repository.LaboratoireRepository;
import com.vitalite.vitalite.repository.PatientRepository;
import com.vitalite.vitalite.repository.PrestationRepository;
import com.vitalite.vitalite.repository.ProduitRepository;
import com.vitalite.vitalite.repository.SoinRepository;
import com.vitalite.vitalite.repository.SousActeRepository;
import com.vitalite.vitalite.repository.TauxRepository;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JsonDataSource;

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
     @Autowired
     private PatientRepository patientRepository;
    @Autowired
    ReportGeneratorService generatorService;
     @Autowired
     private LaboratoireRepository laboratoireRepository;

     @Autowired
     private SousActeRepository sousActeRepository;

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


     public LaboratoireDto createLabo(LaboratoireDto laboratoireDto) {
      Laboratoire dt = mapper.map(laboratoireDto, Laboratoire.class);
      dt.setDateSaissie( LocalDate.now());
      laboratoireRepository.save(dt);
      Optional<Patient> patient =patientRepository.findById(laboratoireDto.getPatientId());
      if(patient.isPresent()) {
         patient.get().setIsLabo(true);
         patientRepository.save(patient.get());
      }
      if(!laboratoireDto.getPrestations().isEmpty()) {
         for(PrestationDto prestationDto: laboratoireDto.getPrestations()) {
            prestationRepository.save(mapper.map(prestationDto, Prestation.class));


         }
      }
      return laboratoireDto;
     }


     public LaboratoireDto updateLabo(LaboratoireDto laboratoireDto) {
      Laboratoire dt = mapper.map(laboratoireDto, Laboratoire.class);
      dt.setDateSaissie( LocalDate.now());
      laboratoireRepository.save(dt);
     /*   Optional<Patient> patient = patientRepository.findById(laboratoireDto.getPatientId());
      if(patient.isPresent()) {
         patient.get().setIsLabo(true);
         patientRepository.save(patient.get());
      }*/
      if(!laboratoireDto.getPrestations().isEmpty()) {
         for(PrestationDto prestationDto: laboratoireDto.getPrestations()) {
            prestationRepository.save(mapper.map(prestationDto, Prestation.class));


         }
      }
      return laboratoireDto;
     }


     public List<LaboratoireDto> findLaborations() {
      return laboratoireRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, LaboratoireDto.class)).collect(Collectors.toList());
   }
     public PatientDto createPatient(PatientDto patientDto){
     
     /*  if(patientDto.getAssureurId() == 0L) {
         patientDto.setAssureurId(null);
      } */
      patientDto.setNumDossier(generateNumero(String.valueOf(patientRepository.findAll().size())));
      Patient dt = mapper.map(patientDto, Patient.class);

      Patient patient=  patientRepository.save(dt);
      if(!patientDto.getPrestations().isEmpty()) {
         int  i = 0;
         for(PrestationDto prestationDto: patientDto.getPrestations()) {

            if(prestationDto.getTauxId() == 0) {
               prestationDto.setTauxId(null);
            }
            Prestation prestation = mapper.map(prestationDto, Prestation.class);
            prestation.setPatient(patient);
            System.out.println("Prestation ==> "+ prestation);
            Optional<Acte>  acte = acteRepository.findById(prestation.getActe().getId());
            if(acte.isPresent() && acte.get().getIsExamen() && i == 0 ) {
               patient.setIsLabo(false);
               i = 1;
            }
            if(prestationDto.getTauxNew() != null && prestationDto.getTauxNew() != BigDecimal.ZERO) {

               Taux taux = new Taux();
               taux.setTauxPourcentage(prestationDto.getTauxNew());
               Taux tauxF = tauxRepository.save(taux);
              
               prestation.setTaux(tauxF);
               
            }

            prestationRepository.save(prestation);
         }
      }
      
      
         
         return patientDto;
     }
     

     public PatientDto updatePatient(PatientDto patientDto){
     
      if(patientDto.getAssureurId() == 0L) {
         patientDto.setAssureurId(null);
      }
      
      Patient dt = mapper.map(patientDto, Patient.class);

      Patient patient =  patientRepository.save(dt);
      if(!patientDto.getPrestations().isEmpty()) {
         int  i = 0;
         for(PrestationDto prestationDto: patientDto.getPrestations()) {
            if(prestationDto.getTauxId() == 0) {
               prestationDto.setTauxId(null);
            }
            Prestation prestation = mapper.map(prestationDto, Prestation.class);
            prestation.getActe().setIsExamen(true);
            if(patient.getIsLabo() == null) {
               if(prestation.getActe().getIsExamen() && i == 0) {
                  patient.setIsLabo(false);
               }
            }
            
            prestation.setPatient(patient);

           
            if(prestationDto.getTauxNew() != null && prestationDto.getTauxNew() != BigDecimal.ZERO) {

               Taux taux = new Taux();
               taux.setTauxPourcentage(prestationDto.getTauxNew());
               Taux tauxF = tauxRepository.save(taux);
              
               prestation.setTaux(tauxF);
               
            }


            prestationRepository.save(prestation);
         }
      }
      
      
         
         return patientDto;
     }
     

     public List<PatientDto> findPatients() {
      return patientRepository.findByDeletedFalse().stream().map(ass->mapper.map(ass, PatientDto.class)).collect(Collectors.toList());
   }

   public List<PatientDto> findPatientsByLabo() {
      return patientRepository.findByIsLaboFalseAndDeletedFalse().stream().map(ass->mapper.map(ass, PatientDto.class)).collect(Collectors.toList());
   }

   public List<PrestationDto> findByPatients(Long patientId) {
      return prestationRepository.findByPatientIdAndDeletedFalse(patientId).stream().map(ass->mapper.map(ass, PrestationDto.class)).collect(Collectors.toList());
   }

   public List<PrestationDto> findByPatientsAndLabo(Long patientId) {
      return prestationRepository.findByPatientIdAndActeIsExamenTrueAndDeletedFalse(patientId).stream().map(ass->mapper.map(ass, PrestationDto.class)).collect(Collectors.toList());
   }


   public void deletePrestation(PrestationDto prestation) {
      Prestation dt = mapper.map(prestation, Prestation.class);
      dt.setDeleted(true);
      prestationRepository.save(dt);

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
     public List<DossierClientDto> findDossierClientsByPeriode(LocalDate dateD, LocalDate dateF) {
    System.out.println("=============================="+dateD+"==========="+dateF);
      return dossierClientRepository.findByAndDateSaissieBetweenAndDeletedFalse(dateD.plusDays(-1L), dateF.plusDays(1L)).stream().map(ass->mapper.map(ass, DossierClientDto.class)).collect(Collectors.toList());
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
               //   prest.setDossierClient(d.get());
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

    

     public List<SousActeDto> findByConvention(Long conventionId) {
      List<SousActeDto> acteDtos = new ArrayList<>();
      conventionActeRepository.findByConventionIdAndDeletedFalse(conventionId)
      .stream().peek(convActe-> {
         SousActeDto  acte = mapper.map(convActe.getSousActe(), SousActeDto.class);
          acte.setMontantConvention(convActe.getMontantConvention());
          acte.setConventionActeId(convActe.getId());
          acteDtos.add(acte);
      }).collect(Collectors.toList());
   return acteDtos;
   }

     public ConventionDto createConvention(ConventionDto conventionDto){
      Convention dt = mapper.map(conventionDto, Convention.class);
      
      Convention convention =  conventionRepository.save(dt);
      
         if(conventionDto.getSousActes() !=null && !conventionDto.getSousActes().isEmpty()) {

            for(SousActeDto acte: conventionDto.getSousActes()) {
               ConventionActe conventionActe = new ConventionActe();
               System.out.println("=============getSousActes==getMontantConvention===="+acte.getMontantConvention());
               if(acte.getMontantConvention() !=null) {
                  conventionActe.setSousActe(mapper.map(acte, SousActe.class));
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
         if(conventionDto.getSousActes() !=null && !conventionDto.getSousActes().isEmpty()) {

            for(SousActeDto acte: conventionDto.getSousActes()) {
               ConventionActe conventionActe = new ConventionActe();
               if(acte.getMontantConvention() !=null) {
                  if(acte.getConventionActeId() !=null) {
                     conventionActe.setId(acte.getConventionActeId());
                  }
                  conventionActe.setSousActe(mapper.map(acte, SousActe.class));
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
                     Optional<ConventionActe> convention = conventionActeRepository.findByDeletedFalseAndConventionIdAndSousActeId(c.get().getId(), acteId);
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

      private byte[] buildReport(
           final Object dto,
            final HashMap<String, ? super Object> parameterMap, Boolean source) throws IOException, JRException {


        
         InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream("reports/recu_vitalite.jrxml");
        //convert DTO into the JsonDatasource
        InputStream jsonFile = this.convertDtoToInputStream(dto);
        System.out.println("le jsonFile"+jsonFile);
        JRDataSource jsonDataSource = new JsonDataSource(jsonFile);
         System.out.println("le fileInputStream"+fileInputStream);
             byte[] reportFile = generatorService.genererRapport(fileInputStream, parameterMap, jsonDataSource,source);
        return reportFile;
    }

    private byte[] buildReportResultatExamen(
           final Object dto,
            final HashMap<String, ? super Object> parameterMap, Boolean source) throws IOException, JRException {


        
         InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream("reports/resultat_examen_vitalite_with_subreport.jasper");
        //convert DTO into the JsonDatasource
        InputStream jsonFile = this.convertDtoToInputStream(dto);
        System.out.println("le jsonFile"+jsonFile);
        JRDataSource jsonDataSource = new JsonDataSource(jsonFile);
         System.out.println("le fileInputStream"+fileInputStream);
             byte[] reportFile = generatorService.genererRapport(fileInputStream, parameterMap, jsonDataSource,source);
        return reportFile;
    }
     
     private InputStream convertDtoToInputStream(final Object dto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Java object to JSON string
        String jsonString = mapper.writeValueAsString(dto);
        //log.info("Json String: " + jsonString);
        //use ByteArrayInputStream to get the bytes of the String and convert them to InputStream.
        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
        return inputStream;
    }

    public CaisseList findCaisseToPrint(Long patientId) {
      List<Caisse> caisses = new ArrayList<>();
      List<Prestation> p = prestationRepository.findByPatientIdAndActeIsExamenFalseAndDeletedFalse(patientId)
      .stream().collect(Collectors.toList());
      System.out.println("this ppppppppppp ==>"+ p.size());
      if(!p.isEmpty()) {
         for(Prestation prest: p) {
            System.out.println("this ppppppppppp 111111==> "+ p.size());
            System.out.println("this ppppppppppp 222222==> "+ prest.getMontantPaye());
            Caisse c = new Caisse();
            c.setSousActe(prest.getSousActe().getLibelle());
            c.setMontant(prest.getMontantPaye());
            c.setMontantAssurer(prest.getMontantAssureur());
            c.setPrixUnitaire(prest.getPrixUnitaire());
            c.setQuantite(prest.getQuantite());
            //c.setMontantTotalAssurer(prest.getMontant().subtract(prest.getMontantPaye()));
            c.setMontantTotal(prest.getMontantPaye());
            System.out.println("MontantTotal ==> "+c.getMontantTotal());
            c.setMontantTotalAssurer(prest.getMontantAssureur().add(prest.getMontantAssureur()));
            //c.setMontantTotalAssureur(prest.getMontantAssureur().add(prest.getMontantAssureur()));
            caisses.add(c);
         }
      }

      return new CaisseList(caisses);
    }

    public CaisseList findResultatExamenToPrint(Long patientId) {
      List<Caisse> caisses = new ArrayList<>();
      List<PrestationDto> p = prestationRepository.findByPatientIdAndActeIsExamenTrueAndDeletedFalse(patientId).stream()
      .map(ass->mapper.map(ass, PrestationDto.class)).collect(Collectors.toList());
      if(!p.isEmpty()) {
         for(PrestationDto prest: p) {
            Caisse c = new Caisse();
            c.setSousActe(prest.getLibelleSousActe());
            c.setMontant(prest.getMontantPaye());
            c.setMontantAssurer(prest.getMontantAssureur());
            System.out.println("prest.getActeId ==> "+ prest.getActeId());
            c.setFamille_acte_id(prest.getActeId());
            if(prest.getActeId() != null) {
               Optional<Acte> acte = acteRepository.findById(prest.getActeId());
               if(acte.isPresent()) {
                  c.setNomActe(acte.get().getLibelle().toUpperCase());
               }
            } 
            c.setValeur(prest.getValeur());
            if(prest.getSousActeId() != null ) {
               Optional<SousActe> s = sousActeRepository.findById(prest.getSousActeId());
               if(s.isPresent()) {
                  c.setValeurNormales(s.get().getValeurNormal());
               }
            } else {
               c.setValeurNormales("Non renseigné");
            }
            
            c.setMontantTotal(prest.getMontantPaye().add(prest.getMontantPaye()));
            System.out.println("MontantTotal ==> "+c.getMontantTotal());
            c.setMontantTotalAssurer(prest.getMontantAssureur().add(prest.getMontantAssureur()));
            //c.setMontantTotalAssureur(prest.getMontantAssureur().add(prest.getMontantAssureur()));
            caisses.add(c);
         }
      }

      return new CaisseList(caisses);
    }
    public String convertMontantChiffreToLettre(BigDecimal bd) { 
 
		//BigDecimal num = new BigDecimal(2718.28);
		RuleBasedNumberFormat formatter = 
		    new RuleBasedNumberFormat(RuleBasedNumberFormat.SPELLOUT);
		String result = formatter.format(bd);
		System.out.println("jqsklhbkldfhbkdlfhklefjbhlefjh "+result);
               return result;
	}

    public byte[] generateReport(Long patientId) throws IOException, JRException {
      System.out.println("le bon id ==>"+patientId);
        HashMap<String, ? super Object> parameterMap = new HashMap<>();
        //CaisseList prestation = new CaisseList(findCaisseToPrint(patientId));
        CaisseList prestation = findCaisseToPrint(patientId);
        System.out.println("le taille des données ==>"+prestation.getCaisses().size());
                 parameterMap.put("donneeCaisse", prestation.getCaisses().get(prestation.getCaisses().size()-1).getMontantTotal());
                 parameterMap.put("somme", prestation.getCaisses().get(prestation.getCaisses().size()-1).getMontantTotal());
                 parameterMap.put("montantAssureur", prestation.getCaisses().get(prestation.getCaisses().size()-1).getMontantAssurer());
                 prestation.getCaisses().size();
                 parameterMap.put("jourDelivre", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                 parameterMap.put("copyright", "Print by Vitalité, All rights reserved");
                 parameterMap.put("montantLettre", convertMontantChiffreToLettre(prestation.getCaisses().get(prestation.getCaisses().size()-1).getMontantTotal()));
                 Optional<Patient> p = patientRepository.findById(patientId);
                 if (p.isPresent()) {
                  parameterMap.put("patient", p.get().getNom()+" "+p.get().getPrenom());
                  parameterMap.put("numero_recu", p.get().getNumDossier());
                 } else {
                  parameterMap.put("patient", "Non renseigné");
                  parameterMap.put("numero_recu", "-");
                 }
                return buildReport( prestation, parameterMap,true);
            
        
    }

    public byte[] generateReportExamen(Long patientId) throws IOException, JRException {
      System.out.println("le bon id ==>"+patientId);
        HashMap<String, ? super Object> parameterMap = new HashMap<>();
        //CaisseList prestation = new CaisseList(findCaisseToPrint(patientId));
        CaisseList prestation = findResultatExamenToPrint(patientId);
        System.out.println("le taille des données 1111111111111==>"+prestation.getCaisses().size());
                 //parameterMap.put("somme", prestation.getCaisses().get(prestation.getCaisses().size()-1).getMontantTotal());
                 prestation.getCaisses().size();
                 // parameterMap.put("lienSecondaire", "src\\main\\resources\\reports\\resultat_examen_vitalite.jrxml");
                 parameterMap.put("lienSecondaire", "reports/resultat_subreport.jasper");
                 parameterMap.put("jourDelivre", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                 parameterMap.put("copyright", "Print by Vitalité, All rights reserved");
                 //parameterMap.put("montantLettre", convertMontantChiffreToLettre(prestation.getCaisses().get(prestation.getCaisses().size()-1).getMontantTotal()));
                 Optional<Patient> p = patientRepository.findById(patientId);
                 if (p.isPresent()) {
                  parameterMap.put("patient", p.get().getNom()+" "+p.get().getPrenom());
                  parameterMap.put("numero_recu", p.get().getNumDossier());
                 } else {
                  parameterMap.put("patient", "Non renseigné");
                  parameterMap.put("numero_recu", "-");
                 }
                return buildReportResultatExamen( prestation, parameterMap,false);
            
        
    }
}
 
