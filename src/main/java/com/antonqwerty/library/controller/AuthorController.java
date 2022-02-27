package com.antonqwerty.library.controller;

import com.antonqwerty.library.dto.AuthorDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Author;
import com.antonqwerty.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(value = "/{id}")
    public Optional<Author> getAuthor(@PathVariable("id") Long id) {
        return authorService.getAuthor(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseDto deleteAuthor(@PathVariable("id") Long id) {
        return authorService.deleteAuthor(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto updateAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(authorDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Author saveAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.saveAuthor(authorDto);
    }
}
