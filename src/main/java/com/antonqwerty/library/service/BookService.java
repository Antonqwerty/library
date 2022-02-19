package com.antonqwerty.library.service;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface BookService {
    ResponseDto createBook(BookDto bookDto);

    ResponseDto deleteBook(Long id);

    ResponseDto updateBook(BookDto bookDto);

    Optional<Book> getBook(Long id);

    ResponseDto saveFile(MultipartFile multipartFile, Long id);
}
