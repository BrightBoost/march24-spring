package com.ilionx.demo.manytomany.service;

import com.ilionx.demo.manytomany.models.AuthorMany;
import com.ilionx.demo.manytomany.models.BookMany;
import com.ilionx.demo.manytomany.repositories.AuthorRepository;
import com.ilionx.demo.manytomany.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // soortgelijke service ook voor author om het andersom te laten werken
    public BookMany addOrUpdateBook(BookMany book) {
        List<AuthorMany> managedAuthors = new ArrayList<>();
        for(AuthorMany author: book.getAuthors()) {
            // haal bestaande author op
            if(author.getId() != null && author.getId() > 0) {
                AuthorMany managedAuthor = authorRepository.getReferenceById(author.getId());
                managedAuthor.getBooks().add(book);
                managedAuthors.add(managedAuthor);
            } else { // sla nieuwe author op
                AuthorMany newAuthor = authorRepository.save(author);
                newAuthor.getBooks().add(book);
                managedAuthors.add(newAuthor);
            }
        }
        book.setAuthors(managedAuthors);
        return bookRepository.save(book);
    }
}
