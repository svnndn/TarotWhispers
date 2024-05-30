package ru.itis.tarot_whispers.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tarot Card Meanings REST API")
                        .version("1.3")
                        .description("Card names, descriptions, and divinatory meanings according to AE Waite's Pictorial Key to the Tarot (1910), the companion to the Rider-Waite-Smith (RWS) deck upon which most newer decks are based."));
    }
}