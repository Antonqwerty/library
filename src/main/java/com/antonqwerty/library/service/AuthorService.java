package com.antonqwerty.library.service;

import com.antonqwerty.library.dto.AuthorDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> getAuthor(Long id);

    Author saveAuthor(AuthorDto authorDto);

    ResponseDto deleteAuthor(Long id);

    ResponseDto updateAuthor(AuthorDto authorDto);
}
