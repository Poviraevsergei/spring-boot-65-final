package com.tms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    static final Logger log = LogManager.getLogger(SpringBoot65FinalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot65FinalApplication.class, args);
    }

}
