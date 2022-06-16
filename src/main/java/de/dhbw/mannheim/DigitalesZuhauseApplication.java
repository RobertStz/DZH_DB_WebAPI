package de.dhbw.mannheim;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@OpenAPIDefinition(info = @Info(title = "WebAPI - Digitales Zuhause",version = "BETA"),
        servers = @Server(url = "http://localhost:8080"))
public class DigitalesZuhauseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalesZuhauseApplication.class, args);
    }

}
