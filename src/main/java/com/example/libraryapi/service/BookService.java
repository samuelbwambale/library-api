package com.example.libraryapi.service;

import com.example.libraryapi.dto.book.BookRequest;

import java.util.List;

public interface BookService {
    /*
        @returns list of Books
     */
    List<BookRequest> listAllBooks();

    /*
        @input id of Book
        @returns BookRequest
     */
    BookRequest getBookById(Long id);

    /*
        @input id of BookRequest
        @returns BookRequest
     */
    BookRequest saveBook(BookRequest bookRequest);

    /*
        @input id of BookRequest
        @input BookRequest details
        @returns BookRequest
     */
    BookRequest updateBook(Long id, BookRequest bookRequest);

    /*
        @input id of BookRequest
     */
    void deleteBook(Long id);

}
