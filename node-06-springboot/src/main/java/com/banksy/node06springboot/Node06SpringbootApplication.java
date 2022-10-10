package com.banksy.node06springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Node06SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Node06SpringbootApplication.class, args);
    }

    @GetMapping
    public String health(){
        return "SUCCESS";
    }
}
