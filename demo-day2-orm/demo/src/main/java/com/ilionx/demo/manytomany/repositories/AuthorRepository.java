package com.ilionx.demo.manytomany.repositories;

import com.ilionx.demo.manytomany.models.AuthorMany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorMany, Long> {
}
