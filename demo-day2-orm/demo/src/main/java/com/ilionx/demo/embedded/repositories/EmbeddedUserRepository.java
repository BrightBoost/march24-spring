package com.ilionx.demo.embedded.repositories;


import com.ilionx.demo.embedded.models.EmbeddedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbeddedUserRepository extends JpaRepository<EmbeddedUser, Long> {
    // Repository methods can be added here
}
