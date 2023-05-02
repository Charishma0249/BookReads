package com.application.bookreads.service;

import com.application.bookreads.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        return books;
    }
}
