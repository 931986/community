package com.example.spring_.commnity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.example.spring_.commnity.controller")
public class CommnityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnityApplication.class, args);
    }

}
