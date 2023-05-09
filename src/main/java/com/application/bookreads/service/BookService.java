package com.application.bookreads.service;

import com.application.bookreads.model.Book;
import com.application.bookreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }
}
