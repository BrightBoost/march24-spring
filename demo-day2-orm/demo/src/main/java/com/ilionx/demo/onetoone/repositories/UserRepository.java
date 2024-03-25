package com.ilionx.demo.onetoone.repositories;

import com.ilionx.demo.onetoone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}