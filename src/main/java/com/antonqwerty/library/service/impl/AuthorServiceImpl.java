package com.antonqwerty.library.service.impl;

import com.antonqwerty.library.dto.AuthorDto;
import com.antonqwerty.library.dto.ResponseDto;
import com.antonqwerty.library.model.Author;
import com.antonqwerty.library.repository.AuthorsRepository;
import com.antonqwerty.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorsRepository authorsRepository;

    @Override
    public Optional<Author> getAuthor(Long id) {
        return authorsRepository.findById(id);
    }

    @Override
    public Author saveAuthor(AuthorDto authorDto) {
        Author author1 = new Author();
        author1.setId(authorDto.getId());
        author1.setName(authorDto.getName());
        author1.setSurname(authorDto.getSurname());
        author1.setDob(authorDto.getDob());
        return authorsRepository.save(author1);
    }

    @Override
    public ResponseDto deleteAuthor(Long id) {
        authorsRepository.deleteById(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Author with id - " + id + " deleted from DB");
        return responseDto;
    }

    @Override
    public ResponseDto updateAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setDob(authorDto.getDob());
        authorsRepository.save(author);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Author - " + author.getName() + author.getSurname() + "Has been updated");
        return responseDto;
    }

}
