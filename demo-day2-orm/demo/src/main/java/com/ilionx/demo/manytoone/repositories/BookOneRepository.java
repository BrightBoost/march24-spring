package com.ilionx.demo.manytoone.repositories;

import com.ilionx.demo.manytoone.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOneRepository extends JpaRepository<Book, Long> {
}
