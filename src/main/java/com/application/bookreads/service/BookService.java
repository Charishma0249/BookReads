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

        // If we delete the old book and save the new book, it is nothing but creating a new record,
        // instead we can retrieve the old book, update it with the new values and re-save it!
        Optional<Book> oldBookOptional = bookRepository.findById(id);

        if(oldBookOptional.isPresent()) {
            Book oldBook = oldBookOptional.get();
            oldBook.setName(newBook.getName());
            oldBook.setDateOfRelease(newBook.dateOfRelease);
            bookRepository.save(oldBook);
        }
    }

    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}
