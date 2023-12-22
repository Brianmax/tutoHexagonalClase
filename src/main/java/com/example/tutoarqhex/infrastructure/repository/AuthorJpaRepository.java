package com.example.tutoarqhex.infrastructure.repository;

import com.example.tutoarqhex.infrastructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {
}
