/**
 * 
 */
package com.xyz.theatre.config;

/**
 * @author PrasadBonam
 *
 */

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI theatreServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Theatre Service API")
                        .description("API documentation for managing theatres, shows, and seats")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("XYZ Booking Platform Team")
                                .email("support@xyz.com")
                                .url("https://xyz.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                );
    }
}
