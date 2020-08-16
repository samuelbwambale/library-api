package com.example.libraryapi;

import com.example.libraryapi.repository.BookRepository;
import com.example.libraryapi.service.BookService;
import com.example.libraryapi.service.BookServiceImpl;
import com.example.libraryapi.dto.book.BookRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookService.class, BookServiceImpl.class, BookRepository.class,WebApplicationContext.class})
@WebAppConfiguration
public class LibraryRestApiTest {


    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookServiceMock;

    @Test
    public void createBookTest() throws Exception {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setAuthor("Temp Author");
        bookRequest.setAvailable(true);
        bookRequest.setBookNumber(100);
        bookRequest.setPublication_date("08/11/2018");
        bookRequest.setTitle("Test book");

        when(bookServiceMock.saveBook(isA(BookRequest.class))).thenReturn(bookRequest);

        mockMvc.perform(post("/books",bookRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author",is("Temp Author")));
    }

}
