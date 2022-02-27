package com.antonqwerty.library.service.impl;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Book;
import com.antonqwerty.library.repository.BookRepository;
import com.antonqwerty.library.service.BookService;
import com.antonqwerty.library.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final FileService fileService;

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

    @Override
    public ResponseDto updateBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setNumbersOfPages(bookDto.getNumbersOfPages());
        bookRepository.save(book);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("book " + book.getName() + " has been updated");
        return responseDto;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @SneakyThrows
    @Override
    @Transactional //коннект к бд, открывает транзацию
    public ResponseDto saveFile(MultipartFile multipartFile, Long id) {
        String path = fileService.saveBook(multipartFile.getBytes(), multipartFile.getOriginalFilename());
        bookRepository.savePath(id, path);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("book " + multipartFile.getOriginalFilename() + " has been saved");
        return responseDto;
    }
}
