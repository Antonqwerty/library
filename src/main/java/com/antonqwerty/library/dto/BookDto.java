package com.antonqwerty.library.dto;

import com.antonqwerty.library.model.Author;
import lombok.Data;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String name;
    private Integer numbersOfPages;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;


}
