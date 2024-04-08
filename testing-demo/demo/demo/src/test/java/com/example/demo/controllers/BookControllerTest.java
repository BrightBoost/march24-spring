package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
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

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getBook_ReturnsBook() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("The Hobbit");

        given(bookRepository.findById(1L)).willReturn(Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(book)));
    }

    @Test
    public void createBook_SavesBook() throws Exception {
        Book book = new Book();
        book.setTitle("A Game of Thrones");

        // Ensure the mock returns a new Author object mimicking what you'd expect from the real method
        given(bookRepository.save(any(Book.class))).willAnswer(invocation -> invocation.getArgument(0));


        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(book)));
    }
}
