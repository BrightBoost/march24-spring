package com.ilionx.demo.manytoone.repositories;

import com.ilionx.demo.manytoone.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
