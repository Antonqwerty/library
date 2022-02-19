package com.antonqwerty.library.dto;

import com.antonqwerty.library.model.Book;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;
    private Short dob;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
