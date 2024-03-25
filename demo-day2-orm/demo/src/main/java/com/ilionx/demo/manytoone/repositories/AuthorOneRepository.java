package com.ilionx.demo.manytoone.repositories;

import com.ilionx.demo.manytoone.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorOneRepository extends JpaRepository<Author, Long> {
}
