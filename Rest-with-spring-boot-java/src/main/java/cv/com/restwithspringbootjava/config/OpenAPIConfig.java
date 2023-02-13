package cv.com.restwithspringbootjava.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI() {

        final var licence = new License()
                .name("Apache 2.0")
                .url("https://www.abola.pt");

        final var info = new Info()
                .title("Restfull API With java 19 and Spring Boot 3.0.2")
                .version("v1")
                .description("Udemy Course")
                .termsOfService("https://www.abola.pt")
                .license(licence);

        return new OpenAPI().info(info);
    }
}