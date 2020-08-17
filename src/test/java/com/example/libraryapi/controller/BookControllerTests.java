package com.example.libraryapi.controller;

import com.example.libraryapi.dto.book.BookRequest;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.service.BookService;
import com.example.libraryapi.service.BookServiceImpl;
import com.example.libraryapi.utils.DateUtil;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
public class BookControllerTests {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void TestListAllBooks() {
//        BookRequest dto1 = new BookRequest();
//        dto1.setId(1L);
//        dto1.setBookNumber(1234);
//        dto1.setTitle("Java Basics");
//        dto1.setAuthor("John Doe");
//        dto1.setPublication_date("08/15/2020");
//        dto1.setAvailable(false);
//
//        BookRequest dto2 = new BookRequest();
//        dto2.setId(2L);
//        dto2.setBookNumber(8976);
//        dto2.setTitle("Covid-19 Symptoms");
//        dto2.setAuthor("NHS");
//        dto2.setPublication_date("04/20/2020");
//        dto2.setAvailable(true);
//
//        List<BookRequest> expectedBooks = Arrays.asList(dto1, dto2);
//
//        when(bookService.listAllBooks()).thenReturn(expectedBooks);
//
//
//        List<BookRequest> actualBooks = bookController.listAllBooks();
//        assertNotNull(actualBooks);
//        assertEquals(2, actualBooks.size());
//        assertEquals("Java Basics", actualBooks.get(0).getTitle());
//    }


}
