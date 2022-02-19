package com.antonqwerty.library.repository;

import com.antonqwerty.library.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author, Long> {
}
