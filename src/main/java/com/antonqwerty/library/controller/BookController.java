package com.antonqwerty.library.controller;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto deleteBook(@RequestParam Long id) {
        return bookService.deleteBook(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto updateBook(@RequestBody BookDto bookDto) {
        return null;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto getBook(@RequestParam Long id) {
        return null;
    }
}
