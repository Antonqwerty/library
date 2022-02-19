package com.antonqwerty.library.repository;

import com.antonqwerty.library.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Modifying //аннотацией мы говорим не ждать никаких entity
    @Query(value = "UPDATE book SET path_files = :path WHERE id = :id", nativeQuery = true)
    void savePath(Long id, String path);
}
