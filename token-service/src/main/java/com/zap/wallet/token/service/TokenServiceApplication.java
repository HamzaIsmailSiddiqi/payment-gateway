package com.zap.wallet.token.service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Zap Token Service", version = "0.0.1", description = "Documentation of Zap Token Service v0.0.1"))
public class TokenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenServiceApplication.class, args);
    }
    
    @Value("${server.servlet.context-path}")
    private String SERVER_CONTEXT_PATH;

    @Bean
    public OpenAPI openAPI() {
        Server localServer = new Server();
        localServer.setDescription("Api Gateway");
        localServer.setUrl(SERVER_CONTEXT_PATH);
        OpenAPI openAPI = new OpenAPI();
        openAPI.setServers(List.of(localServer));
        return openAPI;
    }
}
