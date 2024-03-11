package com.vitalite.vitalite.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.loader.api.BeanMappingBuilder;
import com.github.dozermapper.core.loader.api.TypeMappingOptions;
import com.vitalite.vitalite.entities.DossierClient;
import com.vitalite.vitalite.entities.Examen;
import com.vitalite.vitalite.model.DossierClientDto;
import com.vitalite.vitalite.model.ExamenDto;

@Configuration
public class DozerConfig {
    
      private final  BeanMappingBuilder builder =  new BeanMappingBuilder(){
            @Override
            protected void configure() {
                mapping(ExamenDto.class, Examen.class, TypeMappingOptions.mapNull(false))
                .fields("categorieId","categorie.id")
                .fields("categorie","categorie.libelle");

                mapping(DossierClientDto.class, DossierClient.class, TypeMappingOptions.mapNull(false))
                .fields("assureurId","assureur.id");
                
            }
        };
        
     
        @Bean
        public Mapper builderDozerMapper(){
            return DozerBeanMapperBuilder.create().withMappingBuilder(builder).build();
        }
}
