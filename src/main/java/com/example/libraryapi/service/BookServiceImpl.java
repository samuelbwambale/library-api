package com.example.libraryapi.service;

import com.example.libraryapi.exception.ResourceNotFoundException;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.repository.BookRepository;
import com.example.libraryapi.dto.book.BookRequest;
import com.example.libraryapi.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookRequest> listAllBooks() {
        return bookRepository.findAll()
                .stream().map(this::getBookRequestFromBook)
                .collect(Collectors.toList());
    }

    @Override
    public BookRequest getBookById(Long id) {
        return getBookRequestFromBook(bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found")));
    }

    @Override
    public BookRequest saveBook(BookRequest bookRequest) {
        Book newBook = bookRequestToBookConverter(bookRequest);
        return getBookRequestFromBook(bookRepository.save(newBook));
    }

    @Override
    public BookRequest updateBook(Long id, BookRequest bookRequest) {
        if(!bookRepository.existsById(id)) throw new ResourceNotFoundException("Book with id " + id + " not found");
        bookRequest.setId(id);
        Book book = bookRequestToBookConverter(bookRequest);
        return getBookRequestFromBook(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        bookRepository.delete(existingBook);
    }

    /*
        @input BookRequest details
        @returns Book entity object to save to the database
     */
    private Book bookRequestToBookConverter(BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest,book);
        book.setPublication_date(DateUtil.convertStringToDate(bookRequest.getPublication_date()));
        book.setAvailable(bookRequest.isAvailable());
        return book;
    }

    /*
        @input Book entity
        @returns BookRequest object
     */
    private BookRequest getBookRequestFromBook(Book book)
    {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle(book.getTitle());
        bookRequest.setPublication_date(DateUtil.convertDateToString(book.getPublication_date()));
        bookRequest.setBookNumber(book.getBookNumber());
        bookRequest.setAuthor(book.getAuthor());
        bookRequest.setAvailable(book.isAvailable());
        bookRequest.setId(book.getId());
        return bookRequest;
    }

}
