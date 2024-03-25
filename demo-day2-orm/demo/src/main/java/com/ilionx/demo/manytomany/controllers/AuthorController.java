package com.ilionx.demo.manytomany.controllers;

import com.ilionx.demo.manytomany.models.AuthorMany;
import com.ilionx.demo.manytomany.repositories.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/many/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public ResponseEntity<AuthorMany> createAuthor(@RequestBody AuthorMany author) {
        AuthorMany savedAuthor = authorRepository.save(author);
        return ResponseEntity.ok(savedAuthor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorMany> getAuthor(@PathVariable Long id) {
        AuthorMany author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<AuthorMany>> getAuthors() {
        List<AuthorMany> authors = authorRepository.findAll();
        return ResponseEntity.ok(authors);
    }
}
