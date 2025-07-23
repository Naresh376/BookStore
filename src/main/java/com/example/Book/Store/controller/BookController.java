package com.example.Book.Store.controller;

import com.example.Book.Store.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Book.Store.service.BookService;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> bookList() {
       return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        String string = UUID.randomUUID().toString();
        System.out.println("Generated UUID: " + string);
        book.setIsbn(string);
        return bookService.saveBook(book);
    }

   /* @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id).orElse(null);
    }*/

}
