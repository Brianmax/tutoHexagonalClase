package com.example.tutoarqhex.dominio.ports.in;

import com.example.tutoarqhex.dominio.models.Author;

import java.util.Optional;

public interface AuthorIn {
    Author addAuthor(Author author);
    Optional<Author> findById(Long id);
    Author updateAuthor(Author author, Long id);
    Boolean deleteAuthor(Long id);
}
