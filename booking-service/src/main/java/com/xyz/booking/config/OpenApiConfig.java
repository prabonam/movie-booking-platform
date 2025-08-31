/**
 * 
 */
package com.xyz.booking.config;

/**
 * @author PrasadBonam
 *
 */

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI bookingOpenApi() {
        return new OpenAPI().info(new Info().title("Booking Service API").version("1.0.0")
                .description("APIs for browsing shows and booking tickets"));
    }
}

