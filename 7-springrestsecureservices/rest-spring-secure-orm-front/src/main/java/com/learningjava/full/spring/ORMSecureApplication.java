package com.learningjava.full.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 *
 *
 * Uses JPArepositories for letting available
 * core repositories from another modules
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.learningjava.full.spring")
@EnableJpaRepositories("com.learningjava.full.spring.repository")
public class ORMSecureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ORMSecureApplication.class, args);
    }
}