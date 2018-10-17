package com.learningjava.full.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * com.learningjava.rest.spring.front
 * Class
 * By berto. 12/02/2018
 * <p>
 * <p>
 * Uses JPArepositories annotation for letting available
 * core repositories from another libraries or maven modules
 */
@ComponentScan(basePackages = "com.learningjava.full.spring")
@EnableJpaRepositories("com.learningjava.full.spring.repository")
@SpringBootApplication
public class OAuthSecureApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuthSecureApplication.class, args);
    }
}
