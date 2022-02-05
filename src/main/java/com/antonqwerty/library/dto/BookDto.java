package com.antonqwerty.library.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private Integer numbersOfPages;
}
