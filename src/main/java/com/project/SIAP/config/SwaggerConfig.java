package com.project.SIAP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración Swagger para la generación de documentación API REST
 *
 * HTML: http://localhost:8080/swagger-ui/
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("Spring Boot SIAP API REST",
                "SIAP Api Rest docs",
                "1.0",
                "https://www.google.com",
                new Contact("Juan Pablo Giraldo Collazos",
                        "https://www.google.com",
                        "cpujuanpis@gmail.com"),
                "MIT",
                "https://www.google.com",
                Collections.emptyList()
        );
    }
}
