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
        try {
            authorJpaRepository.save(authorEntity);
            return authorEntity.toDomain();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Author> encontrarId(Long id) {
        Optional<AuthorEntity> authorEntity = authorJpaRepository.findById(id);
        return authorEntity.map(AuthorEntity::toDomain);
    }

    @Override
    public Optional<Author> actualizarAuthor(Author author, Long id) {
        // verify if it exists
        Optional<AuthorEntity> authorEntity = authorJpaRepository.findById(id);
        if (authorEntity.isPresent()) {
            AuthorEntity authorEntity1 = authorEntity.get();
            authorEntity1.setName(author.getName());
            authorEntity1.setLastname(author.getLastname());
            authorEntity1.setEmail(author.getEmail());
            authorJpaRepository.save(authorEntity1);
        }
        return authorEntity.map(AuthorEntity::toDomain);
    }

    @Override
    public Boolean eliminarAuthor(Long id) {
        return null;
    }
}
