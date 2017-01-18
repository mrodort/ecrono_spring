package com.tsystems.ecrono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EcronoSpringApplication {

    public static void main(String[] args) {
	SpringApplication.run(EcronoSpringApplication.class, args);
    }
}
