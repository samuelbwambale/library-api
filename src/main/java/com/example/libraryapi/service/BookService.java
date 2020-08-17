package com.example.libraryapi.service;

import com.example.libraryapi.dto.book.BookRequest;

import java.util.List;

public interface BookService {
    /*
        @returns list of all books
     */
    List<BookRequest> listAllBooks();
    /*
        @input id of book
        @returns book
     */
    BookRequest getBookById(Long id);
    BookRequest saveBook(BookRequest bookRequest);
    BookRequest updateBook(Long id, BookRequest bookRequest);
    void deleteBook(Long id);

}
