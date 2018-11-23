package com.oesia.asistenteconectividad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan(basePackages= {"com.oesia"})
@EntityScan(basePackages = {"com.oesia.model"})
@EnableJpaRepositories(basePackages = {"com.oesia.model"})
@SpringBootApplication
public class asistenteconectividad {

    public static void main(String[] args) {
        SpringApplication.run(asistenteconectividad.class, args);
    }
}