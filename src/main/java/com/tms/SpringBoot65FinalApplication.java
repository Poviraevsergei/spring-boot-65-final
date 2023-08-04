package com.tms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Group 65 project",
                description = "This is pet project",
                contact = @Contact(
                        name = "Poviraev Sergei",
                        email = "teacher@tms.com",
                        url = "@poviraevsergei"
                )

        )
)
@SpringBootApplication
public class SpringBoot65FinalApplication {

    static final Logger log =
            LoggerFactory.getLogger(SpringBoot65FinalApplication.class);

    public static void main(String[] args) {
        log.info("Before Starting application");
        SpringApplication.run(SpringBoot65FinalApplication.class, args);
    }

    //TODO: настройка логов через application.properties
}
