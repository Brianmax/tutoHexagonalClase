package com.example.tutoarqhex.application.useCase;

import com.example.tutoarqhex.dominio.models.Author;
import com.example.tutoarqhex.dominio.ports.in.AuthorIn;
import com.example.tutoarqhex.dominio.ports.out.AuthorOut;

import java.util.Optional;

public class AuthorServiceImpl implements AuthorIn {
    private final AuthorOut authorOut;

    public AuthorServiceImpl(AuthorOut authorOut) {
        this.authorOut = authorOut;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorOut.addAuthor(author);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorOut.findById(id);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        return authorOut.updateAuthor(author, id);
    }

    @Override
    public Boolean deleteAuthor(Long id) {
        return authorOut.deleteAuthor(id);
    }
}
