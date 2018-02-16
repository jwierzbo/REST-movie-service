package net.jwierzbo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    /* Spring Boot entry point*/
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    /*Standalone server entry point (e.g. Tomcat)*/
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
