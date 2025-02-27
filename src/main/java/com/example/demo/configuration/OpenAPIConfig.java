package com.example.demo.configuration;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("group-microservices")
                .packagesToScan("com.example.demo.controllers")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                        new Info()
                                .title("API docs")
                                .version("1.0.0")
                                .description("API description")
                )
                .servers(
                        List.of(
                                new Server().url("http://localhost:8080").description("Local server"),
                                new Server().url("http://localhost:8081").description("Dev server"),
                                new Server().url("http://localhost:8082").description("Test server")
                        )
                );
    }
}
