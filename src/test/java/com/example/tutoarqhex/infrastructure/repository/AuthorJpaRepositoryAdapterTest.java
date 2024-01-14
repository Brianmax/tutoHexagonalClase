package com.example.tutoarqhex.infrastructure.repository;

import com.example.tutoarqhex.dominio.models.Author;
import com.example.tutoarqhex.infrastructure.entity.AuthorEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AuthorJpaRepositoryAdapterTest {
    @Mock
    AuthorJpaRepository authorJpaRepository;
    @InjectMocks
    AuthorJpaRepositoryAdapter authorJpaRepositoryAdapter;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authorJpaRepositoryAdapter = new AuthorJpaRepositoryAdapter(authorJpaRepository);
    }

    @Test
    void agregarAuthorSuccesful() {
        // Arrange

        Author author = new Author(1L, "Renato", "Cisneros", "rcisneros@gmail.com");
        AuthorEntity authorEntity = new AuthorEntity(1L, "Renato", "Cisneros", "rcisneros@gmail.com");

        // Act

        Mockito.when(authorJpaRepository.save(Mockito.any(AuthorEntity.class))).thenReturn(authorEntity);
        Author authorResponse = authorJpaRepositoryAdapter.agregarAuthor(author);

        // Assert

        assertNotNull(authorResponse);
        assertEquals(authorResponse.getId(), author.getId());
    }
    @Test
    void agregarAuthorError() {
        // Arrange
        Author author = new Author(1L, "Renato", "Cisneros", "rcisneros@gmail");
        AuthorEntity authorEntity = new AuthorEntity(2L, "Renato", "Cisneros", "rcisneros@gmail.com");
        // Act

        Mockito.doThrow(new RuntimeException()).when(authorJpaRepository).save(Mockito.any(AuthorEntity.class));
        Author authorResponse = authorJpaRepositoryAdapter.agregarAuthor(author);

        // Assert

        assertNull(authorResponse);
    }

    @Test
    void encontrarIdSuccesful() {
       // Arrange
        Long id = 1L;
        Optional<AuthorEntity> optionalAuthorEntity = Optional.of(new AuthorEntity(1L, "Renato", "Cisneros", "rcisneros@gmail.com"));
       // Act

       Mockito.when(authorJpaRepository.findById(Mockito.anyLong())).thenReturn(optionalAuthorEntity);

       Optional<Author> authorResponse = authorJpaRepositoryAdapter.encontrarId(id);

       // Assert
        assertNotNull(authorResponse);
        assertEquals(authorResponse.get().getId(), id);
    }
    @Test
    void encontrarIdError() {
        // Arrange
        Long id = 1L;
        Optional<AuthorEntity> optionalAuthorEntity = Optional.empty();

        // Act

        Mockito.when(authorJpaRepository.findById(Mockito.anyLong())).thenReturn(optionalAuthorEntity);

        Optional<Author> authorResponse = authorJpaRepositoryAdapter.encontrarId(1L);

        // Assert
        assertNotNull(authorResponse);
        assertEquals(authorResponse, optionalAuthorEntity);
    }

    @Test
    void actualizarAuthorSuccesful() {
        // Arrange
        AuthorEntity authorEntity = new AuthorEntity(1L, "Renato", "Cisneros", "rcisneros@gmail.com");
        Author author = new Author(1L, "Renato", "Cisneros", "rcisneros@gmail.com");
        Optional<AuthorEntity> optionalAuthorEntity = Optional.of(authorEntity);
        // Act
        Mockito.when(authorJpaRepository.findById(Mockito.anyLong())).thenReturn(optionalAuthorEntity);
        Mockito.when(authorJpaRepository.save(Mockito.any(AuthorEntity.class))).thenReturn(authorEntity);

        Optional<Author> authorResponse = authorJpaRepositoryAdapter.actualizarAuthor(author, 1L);

        // Assert
        assertNotNull(authorResponse);
        assertEquals(authorResponse.get().getId(), author.getId());
    }
    @Test
    void actualizarAuthorError() {
        // Arrange
        Long id = 2L;
        AuthorEntity authorEntity = new AuthorEntity(1L, "Renato", "Cisneros", "rcisneros@gmail.com");
        Author author = new Author(2L, "Renato", "Cisneros", "rcisneros@gmail.com");
        Optional<AuthorEntity> optionalAuthorEntity = Optional.empty();

        // Act

        Mockito.when(authorJpaRepository.findById(Mockito.anyLong())).thenReturn(optionalAuthorEntity);

        Optional<Author> authorResponse = authorJpaRepositoryAdapter.actualizarAuthor(author, id);

        // Assert
        assertNotNull(authorResponse);
        assertTrue(authorResponse.isEmpty());
    }
    @Test
    void eliminarAuthor() {
    }
}