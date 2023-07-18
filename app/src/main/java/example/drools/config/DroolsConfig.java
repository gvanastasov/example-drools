package example.drools.config;

import java.io.File;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
    @Bean
    public KieSession kieSession() {
        String rulesPath = "src/main/resources/rules/";
        try {
            KieServices kieServices = KieServices.Factory.get();
            KieFileSystem kfs = kieServices.newKieFileSystem();
            
            File[] drlFiles = new File(rulesPath).listFiles((dir, name) -> name.endsWith(".drl"));
            for (File drlFile : drlFiles) {
                kfs.write(ResourceFactory.newFileResource(drlFile));
            }
            
            KieBuilder kieBuilder = kieServices.newKieBuilder(kfs);
            Results results = kieBuilder.buildAll().getResults();

            if (results.hasMessages(Message.Level.ERROR)) {
                System.out.println(results.getMessages());
            }
            
            KieRepository kieRepository = kieServices.getRepository();
            KieContainer kieContainer = kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
            return kieContainer.newKieSession();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
