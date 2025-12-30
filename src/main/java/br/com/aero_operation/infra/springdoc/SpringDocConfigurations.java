package br.com.aero_operation.infra.springdoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Doctor API")
                    .description("A REST API built with Java and Spring Boot")
                        .contact(new Contact()
                            .name("Team Backend")
                            .email("feelipe.devloper@gmail.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http:/api/licenca")));
    }

}