package com.example.tutoarqhex.dominio.ports.out;

import com.example.tutoarqhex.dominio.models.Author;

import java.util.Optional;

public interface AuthorOut {
    Author addAuthor(Author author);
    Optional<Author> findById(Long id);
    Author updateAuthor(Author author, Long id);
    Boolean deleteAuthor(Long id);
}
