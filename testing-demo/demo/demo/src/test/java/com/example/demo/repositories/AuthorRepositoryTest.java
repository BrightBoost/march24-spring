package com.example.demo.repositories;

import com.example.demo.models.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void saveAuthor_PersistAuthor() {
        Author author = new Author();
        author.setName("Neil Gaiman");

        Author savedAuthor = authorRepository.save(author);

        assertThat(savedAuthor).isNotNull();
        assertThat(savedAuthor.getId()).isNotNull();
        assertThat(savedAuthor.getName()).isEqualTo("Neil Gaiman");
    }

    @Test
    public void findById_ReturnsAuthor() {
        Author author = new Author();
        author.setName("Terry Pratchett");
        entityManager.persistAndFlush(author);

        Optional<Author> foundAuthor = authorRepository.findById(author.getId());

        assertThat(foundAuthor).isPresent();
        assertThat(foundAuthor.get().getName()).isEqualTo("Terry Pratchett");
    }
}
