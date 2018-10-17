package com.learningjava.rest.spring.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 */
@SpringBootApplication
public class SpringBootKeycloakWebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootKeycloakWebApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKeycloakWebApplication.class, args);
    }
}