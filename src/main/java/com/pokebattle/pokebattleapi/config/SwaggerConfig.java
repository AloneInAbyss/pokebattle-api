package com.pokebattle.pokebattleapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Value("${project.version}")
    private String projectVersion;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("PokéBattle API")
            .version(projectVersion))
            .externalDocs(new ExternalDocumentation()
            .description("PokéBattle API GitHub")
            .url("https://github.com/AloneInAbyss/pokebattle-api"));
    }
    
}
