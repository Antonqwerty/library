package com.antonqwerty.library.controller;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.model.Book;
import com.antonqwerty.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    void createBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void updateBook() throws Exception {
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(Mockito.any());
        String request = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Idiot\",\n" +
                "    \"numbersOfPages\": 300,\n" +
                "    \"pathFiles\": null\n" +
                "}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/book")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(request);
        String response = "{\"message\":\"book Idiot has been updated\"}";
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(response);
        mockMvc.perform(requestBuilder).andExpect(resultMatcher);
    }

    @Test
    void getBook() throws Exception {
        Book book = new Book();
        book.setId(1L);
        book.setName("war_and_peace");
        book.setNumbersOfPages(300);
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/1");
        String response = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"war_and_peace\",\n" +
                "    \"numbersOfPages\": 300,\n" +
                "    \"pathFiles\": null\n" +
                "}";
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(response);
        mockMvc.perform(requestBuilder).andExpect(resultMatcher);
    }

    @Test
    void saveBook() {
    }
}