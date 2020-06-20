package com.boot.librarymanagement.service;

import com.boot.librarymanagement.entity.Book;
import com.boot.librarymanagement.entity.Library;
import com.boot.librarymanagement.model.BookResponseType;
import com.boot.librarymanagement.model.BookType;
import com.boot.librarymanagement.model.ResponseType;
import com.boot.librarymanagement.repo.BookRepo;
import com.boot.librarymanagement.repo.LibraryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    LibraryRepo libraryRepo;

    @Autowired
    BookRepo bookRepo;

    public BookResponseType getBook(String id) {
        Book book = bookRepo.getOne(Long.valueOf(id));
        BookResponseType responseType = new BookResponseType();
        BeanUtils.copyProperties(book, responseType);
        return responseType;
    }

    public BookResponseType getBooks() {
        System.out.println("getting all books");
        List<Book> books = bookRepo.findAll();
        System.out.println(books.size());
        BookResponseType responseType = new BookResponseType();
        List<BookType> bookTypes = books.stream().map(book -> {
            BookType bookType = new BookType();
            BeanUtils.copyProperties(book, bookType);
            return bookType;
        }).collect(Collectors.toList());

        System.out.println(bookTypes.size());
        responseType.setBooks(bookTypes);
        return responseType;
    }

    public BookResponseType addBook(BookType bookType, String name) {
        System.out.println("add book");
        Library library = libraryRepo.findBySectionName(name);
        Book book = new Book();
        BeanUtils.copyProperties(bookType, book);
        if(library.getBooks() !=null && library.getBooks().size()>0){
            library.getBooks().add(book);
        }else{
            library.setBooks(new ArrayList<>());
            library.getBooks().add(book);
        }
        library = libraryRepo.save(library);
        BookResponseType responseType = new BookResponseType();
        if(library != null)
            responseType.setBook(bookType);
        return  responseType;
    }

}
