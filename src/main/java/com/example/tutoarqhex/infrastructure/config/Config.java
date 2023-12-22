package com.example.tutoarqhex.infrastructure.config;

import com.example.tutoarqhex.application.service.AuthorService;
import com.example.tutoarqhex.application.useCase.AuthorServiceImpl;
import com.example.tutoarqhex.dominio.ports.out.AuthorOut;
import com.example.tutoarqhex.infrastructure.repository.AuthorJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public AuthorService authorService(AuthorOut authorOut)
    {
        return new AuthorService(new AuthorServiceImpl(authorOut));
    }
    @Bean
    public AuthorOut authorOut(AuthorJpaRepositoryAdapter authorJpaRepositoryAdapter)
    {
        return authorJpaRepositoryAdapter;
    }
}
