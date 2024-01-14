package com.example.tutoarqhex.dominio.ports.out;

import com.example.tutoarqhex.dominio.models.Author;

import java.util.Optional;

public interface AuthorOut {
    Author agregarAuthor(Author author);
    Optional<Author> encontrarId(Long id);
    Optional<Author> actualizarAuthor(Author author, Long id);
    Boolean eliminarAuthor(Long id);
}
