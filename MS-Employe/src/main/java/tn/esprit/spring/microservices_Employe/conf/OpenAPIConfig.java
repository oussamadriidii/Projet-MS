package tn.esprit.spring.microservices_Employe.conf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Employee API")
                        .description("Employee management API")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Oussama Dridi")
                                .email("Dridi.oussama@esprit.tn")));
    }
}

