package com.antonqwerty.library.controller;

import com.antonqwerty.library.dto.BookDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Book;
import com.antonqwerty.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
        return bookService.updateBook(bookDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        return bookService.getBook(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @PostMapping(value = "/{id}/load", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto saveBook(@RequestPart MultipartFile multipartFile, @PathVariable Long id) {
        return bookService.saveFile(multipartFile, id);
    }
}
//дописать оставшиеся методы+создать новую ветку и запушить результат и создать пулреквест
//сделать контроллер по авторам,сохранеие и тд; попробовать сделать получения файла; добавить метод получение всех книг.
//сделать тесты на методы автора или книги.