package com.example.tutoarqhex.infrastructure.entity;

import com.example.tutoarqhex.dominio.models.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorEntityTest {

    @Test
    void fromModel() {
        // Arrange
        Author author = new Author();
        author.setId(1L);
        author.setName("John");
        author.setLastname("Doe");
        author.setEmail("john.doe@example.com");

        // Act

        AuthorEntity authorEntity = AuthorEntity.fromModel(author);

        // Assert

        assertEquals(1L, authorEntity.getId().longValue());
        assertEquals("John", authorEntity.getName());
        assertEquals("Doe", authorEntity.getLastname());
        assertEquals("john.doe@example.com", authorEntity.getEmail());

    }
    @Test
    void toDomain() {
        // Arrange
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(1L);
        authorEntity.setName("John");
        authorEntity.setLastname("Doe");
        authorEntity.setEmail("john.doe@example.com");

        // Act

        Author author = authorEntity.toDomain();

        // Assert

        assertEquals(1L, author.getId().longValue());
        assertEquals("John", author.getName());
        assertEquals("Doe", author.getLastname());
        assertEquals("john.doe@example.com", author.getEmail());
    }
}