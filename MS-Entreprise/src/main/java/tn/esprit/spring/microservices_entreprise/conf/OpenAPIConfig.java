package tn.esprit.spring.microservices_entreprise.conf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.Line;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI entrepriseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservice Entreprise API")
                        .description("Documentation de l'API pour la gestion des entreprises et employés.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Oussama Dridi")
                                .email("contact@entreprise.tn")
                                .url("https://www.entreprise.tn"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

    // Groupement optionnel des endpoints sous /api/**
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("entreprise-public")
                .pathsToMatch("/api/**") // ou adapte selon ton URL base
                .build();
    }
}
