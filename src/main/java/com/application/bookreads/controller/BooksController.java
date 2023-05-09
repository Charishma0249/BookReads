package com.application.bookreads.controller;

import com.application.bookreads.model.Book;
import com.application.bookreads.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/books/{id}")
    @ResponseBody
    public Optional<Book> getBookById(@PathVariable Long id) {

        return bookService.getBookById(id);
    }

    @GetMapping("/books/name")
    @ResponseBody
    public Book getBookByName(@RequestParam String name) {

        return bookService.getBookByName(name);
    }
}
