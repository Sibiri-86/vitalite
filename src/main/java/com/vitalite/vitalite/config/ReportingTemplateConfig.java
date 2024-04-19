/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitalite.vitalite.config;
import com.vitalite.vitalite.model.report.TypeReporting;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author HP
 */
@Configuration
public class ReportingTemplateConfig {
    
    private static final String REPORT_ROOT = "reports/";
    private static final String REPORT_CAISSE = REPORT_ROOT + "caisse.jrxml";
    
    
    


    

    @Bean
    public ReportingTemplate configure(){
        Map<String, String> map = Stream.of(
                new AbstractMap.SimpleImmutableEntry<>(TypeReporting.CAISSE.name(), REPORT_CAISSE)
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new ReportingTemplate(map);
    }  
    
    public static class ReportingTemplate{
        private Map<String, String> templateMap;
        public Map<String, String> getTemplateMap() {
            return templateMap;
        }
        
        public void setTemplateMap(Map<String, String> templateMap) {
            this.templateMap = templateMap;
        }
        public ReportingTemplate(Map<String, String> templateMap) {
            this.templateMap = templateMap;
        }
        public ReportingTemplate() {
        }
    }
    
    
}
