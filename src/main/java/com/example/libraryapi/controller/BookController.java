package com.example.libraryapi.controller;

import com.example.libraryapi.service.BookService;
import com.example.libraryapi.dto.book.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookRequest> listAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public BookRequest getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookRequest saveBook(@Valid @RequestBody BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }

    @PutMapping("/{id}")
    public BookRequest updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book successfully deleted";
    }
}

