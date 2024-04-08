package com.example.demo.repositories;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void saveBook_PersistBookWithAuthor() {
        Author author = new Author();
        author.setName("J.K. Rowling");
        entityManager.persist(author);

        Book book = new Book();
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);

        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("Harry Potter and the Sorcerer's Stone");
        assertThat(savedBook.getAuthor()).isEqualTo(author);
    }

    @Test
    public void findById_ReturnsBook() {
        Book book = new Book();
        book.setTitle("The Colour of Magic");
        Author author = new Author();
        author.setName("Terry Pratchett");
        book.setAuthor(author);

        entityManager.persist(author);
        entityManager.persistAndFlush(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());

        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getTitle()).isEqualTo("The Colour of Magic");
        assertThat(foundBook.get().getAuthor().getName()).isEqualTo("Terry Pratchett");
    }
}
