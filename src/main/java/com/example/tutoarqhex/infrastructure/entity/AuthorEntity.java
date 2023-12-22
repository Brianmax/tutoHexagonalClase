package com.example.tutoarqhex.infrastructure.entity;

import com.example.tutoarqhex.dominio.models.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastname;
    String email;

    public static AuthorEntity fromModel(Author author)
    {
        AuthorEntity authorEntity =  new AuthorEntity();
        authorEntity.setId(author.getId());
        authorEntity.setName(author.getName());
        authorEntity.setLastname(author.getLastname());
        authorEntity.setEmail(author.getEmail());
        return authorEntity;
    }

    public Author toDomain()
    {
        Author author = new Author();
        author.setId(this.id);
        author.setName(this.name);
        author.setLastname(this.lastname);
        author.setEmail(this.email);
        return author;
    }
}
