package com.example.mydrools_excel;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolConfig {
    KieServices kieServices = KieServices.Factory.get();
    @Bean
    public KieSession getKieSession(){
        Resource dt
                = ResourceFactory
                .newClassPathResource("Discount.drl.xlsx",
                        getClass());

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
        KieContainer kieContainer
                = kieServices.newKieContainer(krDefaultReleaseId);
        KieSession kieSession = kieContainer.newKieSession();
        return kieSession;
    }

}
