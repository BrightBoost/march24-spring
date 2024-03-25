package com.ilionx.demo.manytomany.controllers;

import com.ilionx.demo.manytomany.models.BookMany;
import com.ilionx.demo.manytomany.repositories.BookRepository;
import com.ilionx.demo.manytomany.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/many/books")
public class BookController {

    private BookRepository bookRepository;
    private BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookMany> createBook(@RequestBody BookMany book) {
        BookMany savedBook = bookService.addOrUpdateBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookMany> getBook(@PathVariable Long id) {
        BookMany book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<BookMany>> getBooks() {
        List<BookMany> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }}
