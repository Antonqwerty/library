package com.antonqwerty.library.dto;

import lombok.Data;
import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String name;
    private Integer numbersOfPages;
    private List<Long> authorsId;
}
