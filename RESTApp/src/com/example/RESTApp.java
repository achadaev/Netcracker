package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RESTApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RESTApp.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
