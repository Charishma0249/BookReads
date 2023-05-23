package com.application.bookreads.service;

import com.application.bookreads.model.Book;
import com.application.bookreads.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book getBookByName(String name) {
        return bookRepository.findByName(name);
    }

    public void updateBook(Book newBook, Long id) {

        //TODO: change to update if it does not work
        Optional<Book> oldBook = bookRepository.findById(id);
        newBook.id = id;
        bookRepository.deleteById(id);
        bookRepository.save(newBook);
    }

    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}
