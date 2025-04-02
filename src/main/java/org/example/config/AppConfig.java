package org.example.config;

import org.example.data_access.impl.StudentDaoListImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
