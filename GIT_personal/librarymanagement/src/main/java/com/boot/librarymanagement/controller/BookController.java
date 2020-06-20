package com.boot.librarymanagement.controller;

import com.boot.librarymanagement.model.BookResponseType;
import com.boot.librarymanagement.model.BookType;
import com.boot.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/library")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/book/{id}")
    public BookResponseType getBook(@PathVariable String id){
        System.out.println("get book of id "+id);
        return bookService.getBook(id);
    }

    @GetMapping(path = "/books")
    public BookResponseType getBooks() {
        System.out.println("fetching all books");
        return bookService.getBooks();
    }
    @PostMapping(path = "/section/{name}/book")
    public BookResponseType addBook(@RequestBody BookType bookType,@PathVariable String name) {
        System.out.println("add book");
        return bookService.addBook(bookType,name);
    }
}
