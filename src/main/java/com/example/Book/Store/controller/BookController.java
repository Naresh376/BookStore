package com.example.Book.Store.controller;

import com.example.Book.Store.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Book.Store.service.BookService;


import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/books")
    public List<Book> bookList() {
       return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        String string = UUID.randomUUID().toString();
        log.info("Generating unique ID for book: {}", string);
        book.setIsbn(string);
        return bookService.saveBook(book);
    }

   /* @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id).orElse(null);
    }*/

}
