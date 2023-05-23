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

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping("/get/all")
    @ResponseBody
    public List<Book> getBooks() {

        return bookService.getBooks();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addBooks(@RequestBody List<Book> books) {
        bookService.addBooks(books);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateBook(@PathVariable Long id, @RequestBody Book book) {

        bookService.updateBook(book, id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<Book> getBookById(@PathVariable Long id) {

        return bookService.getBookById(id);
    }

    @GetMapping("/get")
    @ResponseBody
    public Book getBookByName(@RequestParam String name) {

        //use regex to filter out the list of books with the same name
        return bookService.getBookByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
