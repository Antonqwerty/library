package com.antonqwerty.library.service;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.dto.ResponseDto;

public interface BookService {
    ResponseDto createBook(BookDto bookDto);

    ResponseDto deleteBook(Long id);
}
