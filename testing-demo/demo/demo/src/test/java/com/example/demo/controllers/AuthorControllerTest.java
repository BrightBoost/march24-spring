package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAuthor_ReturnsAuthor() throws Exception {
        Author author = new Author();
        author.setId(1L);
        author.setName("J.R.R. Tolkien");

        given(authorRepository.findById(1L)).willReturn(Optional.of(author));

        mockMvc.perform(get("/api/authors/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(author)));
    }

    @Test
    public void createAuthor_SavesAuthor() throws Exception {
        Author author = new Author();
        author.setName("George R.R. Martin");

        // Ensure the mock returns a new Author object mimicking what you'd expect from the real method
        given(authorRepository.save(any(Author.class))).willAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(post("/api/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(author)));
    }
}
