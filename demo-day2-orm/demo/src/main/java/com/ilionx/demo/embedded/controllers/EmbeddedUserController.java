package com.ilionx.demo.embedded.controllers;

import com.ilionx.demo.embedded.models.EmbeddedUser;
import com.ilionx.demo.embedded.repositories.EmbeddedUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/embeddedUsers")
public class EmbeddedUserController {

    private EmbeddedUserRepository userRepository;

    public EmbeddedUserController(EmbeddedUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<EmbeddedUser> createUser(@RequestBody EmbeddedUser user) {
        EmbeddedUser savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Add other CRUD endpoints as needed...
}
