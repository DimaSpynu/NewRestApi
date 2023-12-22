package com.spynu.newrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.spynu.newrestapi.repository")
@SpringBootApplication
public class NewRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewRestApiApplication.class, args);
    }

}
