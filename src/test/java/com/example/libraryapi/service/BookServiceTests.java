package com.example.libraryapi.service;

import com.example.libraryapi.dto.book.BookRequest;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.repository.BookRepository;
import com.example.libraryapi.utils.DateUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService = new BookServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testListAllBooks() {
        Book testBook1 = new Book();
        testBook1.setBookNumber(1234);
        testBook1.setTitle("Java Basics");
        testBook1.setAuthor("John Doe");
        testBook1.setPublication_date(DateUtil.convertStringToDate("08/15/2020"));
        testBook1.setAvailable(false);

        Book testBook2 = new Book();
        testBook2.setBookNumber(8976);
        testBook2.setTitle("Covid-19 Symptoms");
        testBook2.setAuthor("NHS");
        testBook2.setPublication_date(DateUtil.convertStringToDate("04/20/2020"));
        testBook2.setAvailable(true);

        List<Book> expectedBooks = Arrays.asList(testBook1, testBook2);

        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<BookRequest> actualBooks = bookService.listAllBooks();
        assertNotNull(actualBooks);
        assertEquals(2, actualBooks.size());
        assertEquals("Java Basics", actualBooks.get(0).getTitle());

    }
}
