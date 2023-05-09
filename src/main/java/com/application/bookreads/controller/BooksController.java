package com.application.bookreads.controller;

import com.application.bookreads.model.Book;
import com.application.bookreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addBooks(@RequestBody List<Book> books) {
        bookService.addBooks(books);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
