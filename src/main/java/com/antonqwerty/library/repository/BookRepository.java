package com.antonqwerty.library.repository;

import com.antonqwerty.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
