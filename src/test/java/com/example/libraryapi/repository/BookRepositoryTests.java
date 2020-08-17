package com.example.libraryapi.repository;

import com.example.libraryapi.dto.book.BookRequest;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.utils.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class BookRepositoryTests {

    private Book testBook  = new Book();

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() {
        testBook.setBookNumber(1234);
        testBook.setTitle("Java Basics");
        testBook.setAuthor("John Doe");
        testBook.setPublication_date(DateUtil.convertStringToDate("08/15/2020"));
        testBook.setAvailable(false);
        bookRepository.save(testBook);
    }

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setBookNumber(1234);
        book.setTitle("Java Basics");
        book.setAuthor("John Doe");
        book.setPublication_date(DateUtil.convertStringToDate("08/15/2020"));
        book.setAvailable(false);
        Book savedBook = bookRepository.save(book);
        assertEquals(savedBook.getBookNumber(), 1234);

    }

    @Test
    public void testListAllBooks() {
        assertEquals(1, bookRepository.findAll().size());
    }

    @Test
    public void testGetBookById() {
        assertEquals(testBook, bookRepository.findById(1L).get());
    }

    @Test
    public void testDeleteBook() {
        bookRepository.delete(testBook);
        assertEquals(0, bookRepository.findAll().size());

    }
}