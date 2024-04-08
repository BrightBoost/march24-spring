package com.example.demo.repositories;

import com.example.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Repository methods can be added here
}
