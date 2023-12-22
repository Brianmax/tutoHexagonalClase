package com.example.tutoarqhex;

import com.example.tutoarqhex.application.service.AuthorService;
import com.example.tutoarqhex.application.useCase.AuthorServiceImpl;
import com.example.tutoarqhex.dominio.ports.in.AuthorIn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutoArqHexApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutoArqHexApplication.class, args);
    }

}
