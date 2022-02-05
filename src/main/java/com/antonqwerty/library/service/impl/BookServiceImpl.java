package com.antonqwerty.library.service.impl;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Book;
import com.antonqwerty.library.repository.BookRepository;
import com.antonqwerty.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public ResponseDto createBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setNumbersOfPages(bookDto.getNumbersOfPages());
        bookRepository.save(book);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("book " + book.getName() + " created successfully");
        return responseDto;
    }

    @Override
    public ResponseDto deleteBook(Long id) {
        bookRepository.deleteById(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("book " + id + " deleted successfully");
        return responseDto;
    }

}
