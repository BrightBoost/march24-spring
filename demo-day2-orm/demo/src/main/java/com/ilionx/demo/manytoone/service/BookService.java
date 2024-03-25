package com.ilionx.demo.manytoone.service;

import com.ilionx.demo.manytoone.models.Author;
import com.ilionx.demo.manytoone.models.Book;
import com.ilionx.demo.manytoone.repositories.AuthorRepository;
import com.ilionx.demo.manytoone.repositories.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book addBook(Book book) {
        if(book.getAuthor() != null && book.getAuthor().getId() != null && book.getAuthor().getId() > 0) {
            Author author = authorRepository.findById(book.getAuthor().getId()).orElse(null);
            book.setAuthor(author);
        }
        return bookRepository.save(book);
    }
}
