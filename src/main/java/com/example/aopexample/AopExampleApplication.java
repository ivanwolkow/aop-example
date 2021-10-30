package com.example.aopexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopExampleApplication implements CommandLineRunner {

    @Autowired
    BasicService basicService;

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        basicService.extractDate(LocalDateTime.now());
        basicService.throwingMethod(null);
    }
}
