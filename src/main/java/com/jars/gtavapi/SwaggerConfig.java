package com.jars.gtavapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("https://gtav-api-production.up.railway.app");
        server.setDescription("GTA V API Server");

        Contact myContact = new Contact();
        myContact.setName("JarssS8");
        myContact.setEmail("adraincgs@gmail.com");

        Info information = new Info()
                .title("Gta V API Documentation")
                .version("1.0")
                .description("This is a simple API for GTA V cars.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}

