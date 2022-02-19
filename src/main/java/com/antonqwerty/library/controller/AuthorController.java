package com.antonqwerty.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    @PostMapping
    public String createAuthor() {
        return "Author has been created";
    }

    @GetMapping(value = "/{id}")
    public String getAuthor(@PathVariable("id") Long id) {
        return "SHOW AUTHOR";
    }
}
