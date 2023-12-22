package com.example.tutoarqhex.infrastructure.repository;

import com.example.tutoarqhex.dominio.models.Author;
import com.example.tutoarqhex.dominio.ports.out.AuthorOut;
import com.example.tutoarqhex.infrastructure.entity.AuthorEntity;
import org.hibernate.boot.model.internal.OptionalDeterminationSecondPass;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AuthorJpaRepositoryAdapter implements AuthorOut {
    private final AuthorJpaRepository authorJpaRepository;

    public AuthorJpaRepositoryAdapter(AuthorJpaRepository authorJpaRepository) {
        this.authorJpaRepository = authorJpaRepository;
    }

    @Override
    public Author agregarAuthor(Author author) {
        AuthorEntity authorEntity = AuthorEntity.fromModel(author);
        return authorJpaRepository.save(authorEntity).toDomain();
    }

    @Override
    public Optional<Author> encontrarId(Long id) {
        Optional<AuthorEntity> optionalAuthorEntity = authorJpaRepository.findById(id);
        if(optionalAuthorEntity.isPresent())
        {
            return Optional.of(optionalAuthorEntity.get().toDomain());
        }
        return Optional.empty();
    }

    @Override
    public Author actualizarAuthor(Author author, Long id) {
        return null;
    }

    @Override
    public Boolean eliminarAuthor(Long id) {
        return null;
    }
}
