package com.project.odontologia.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Estoque Odontológico API")
                        .description("API de gerenciamento de estoque de materiais odontológicos")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                        .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Documentation")
                        .url("https://springdoc.org/"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("odontologia")
                .pathsToMatch("/**")
                .build();
    }
}
