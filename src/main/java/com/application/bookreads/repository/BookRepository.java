package com.application.bookreads.repository;

import com.application.bookreads.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findByName(String name);
}


