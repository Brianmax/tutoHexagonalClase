package com.example.tutoarqhex.infrastructure.controller;

import com.example.tutoarqhex.application.service.AuthorService;
import com.example.tutoarqhex.dominio.models.Author;
import com.example.tutoarqhex.infrastructure.entity.AuthorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class AuthorController {
    private final AuthorService authorService; // uso de la interfaz de entrada

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/agregarUsuario")
    Author agregarUsuario(@RequestBody Author author)
    {
        return authorService.addAuthor(author);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> buscarId(@PathVariable Long id){
        Optional<Author> author = authorService.findById(id);
        if(author.isPresent())
        {
            return ResponseEntity.ok(author.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/actualizarUsuario/{id}")
    ResponseEntity<?> actualizarUsuario(@RequestBody Author author, @PathVariable Long id)
    {
        Optional<Author> author1 = authorService.updateAuthor(author, id);
        if(author1.isPresent())
        {
            return ResponseEntity.ok(author1.get());
        }
        return ResponseEntity.notFound().build();
    }
}
