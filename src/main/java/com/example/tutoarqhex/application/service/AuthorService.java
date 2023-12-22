package com.example.tutoarqhex.application.service;

import com.example.tutoarqhex.dominio.models.Author;
import com.example.tutoarqhex.dominio.ports.in.AuthorIn;

import java.util.Optional;

public class AuthorService implements AuthorIn {
    private final AuthorIn authorIn; // AuthorServiceImpl

    public AuthorService(AuthorIn authorIn) {
        this.authorIn = authorIn;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorIn.addAuthor(author); // authorServiceImpl.addAuthor()
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorIn.findById(id);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        return authorIn.updateAuthor(author, id);
    }

    @Override
    public Boolean deleteAuthor(Long id) {
        return authorIn.deleteAuthor(id);
    }
}
