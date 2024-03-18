package com.vitalite.vitalite.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.TypeMappingOptions;
import com.vitalite.vitalite.entities.Acte;
import com.vitalite.vitalite.entities.Convention;
import com.vitalite.vitalite.entities.ConventionActe;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.entities.Examen;
import com.vitalite.vitalite.entities.Prestation;
import com.vitalite.vitalite.entities.Soin;
import com.vitalite.vitalite.model.ActeDto;
import com.vitalite.vitalite.model.ConventionActeDto;
import com.vitalite.vitalite.model.ConventionDto;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.ExamenDto;
import com.vitalite.vitalite.model.PrestationDto;
import com.vitalite.vitalite.model.SoinDto;

@Configuration
public class DozerConfig {
    
      private final  BeanMappingBuilder builder =  new BeanMappingBuilder(){
            @Override
            protected void configure() {
                mapping(ExamenDto.class, Examen.class, TypeMappingOptions.mapNull(false))
                .fields("categorieId","categorie.id")
                .fields("categorie","categorie.libelle");

                mapping(DossierClientDto.class, DossierClient.class, TypeMappingOptions.mapNull(false))
                .fields("assureurId","assureur.id")
                .fields("assureur","assureur.libelle")
                .fields("tauxId","taux.id")
                .fields("taux","taux.tauxPourcentage");

                mapping(PrestationDto.class, Prestation.class, TypeMappingOptions.mapNull(false))
                .fields("dossierClientId","dossierClient.id")
                .fields("acteId","acte.id")
                .fields("soinId","soin.id");                

                mapping(ConventionDto.class, Convention.class, TypeMappingOptions.mapNull(false))
                .fields("assureurId","assureur.id")
                .fields("assureur","assureur.libelle");

                mapping(SoinDto.class, Soin.class, TypeMappingOptions.mapNull(false))
                .fields("dossierClientId","dossierClient.id");

                mapping(ConventionActeDto.class, ConventionActe.class, TypeMappingOptions.mapNull(false))
                .fields("conventionId","convention.id")
                .fields("acteId","acte.id");
               
            
            }
        };
        
     
        @Bean
        public Mapper builderDozerMapper(){
            return DozerBeanMapperBuilder.create().withMappingBuilder(builder).build();
        }
}
