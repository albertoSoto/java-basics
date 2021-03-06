package com.learningjava.full.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 *
 *
 * Uses JPArepositories annotation for letting available
 * core repositories from another libraries or maven modules
 */

//@ComponentScan(basePackages = "com.learningjava.full.spring")
@SpringBootApplication
@EnableJpaRepositories("com.learningjava.full.spring.repository")
public class ORMSecureApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ORMSecureApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ORMSecureApplication.class);
    }
}