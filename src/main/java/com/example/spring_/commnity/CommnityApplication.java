package com.example.spring_.commnity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//=@SpringBootApplication(scanBasePackages="com.example.spring_.commnity")
@SpringBootApplication
//@ComponentScan(basePackages ={"com.example.spring_.commnity" })
public class CommnityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommnityApplication.class, args);
    }

}
