package com.ilionx.demo.manytomany.repositories;

import com.ilionx.demo.manytomany.models.BookMany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookMany, Long> {
}
