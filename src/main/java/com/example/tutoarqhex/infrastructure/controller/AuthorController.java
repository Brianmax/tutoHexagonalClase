package com.example.tutoarqhex.infrastructure.controller;

import com.example.tutoarqhex.application.service.AuthorService;
import com.example.tutoarqhex.dominio.models.Author;
import com.example.tutoarqhex.infrastructure.entity.AuthorEntity;
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
    Author buscarId(@PathVariable Long id){
        return authorService.findById(id).get();
    }
}
