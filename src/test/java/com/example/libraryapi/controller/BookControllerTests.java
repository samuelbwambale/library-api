package com.example.libraryapi.controller;

import com.example.libraryapi.dto.book.BookRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetListOfBooks() throws Exception {
        List<BookRequest> bookRequests = this.restTemplate.getForObject("http://localhost:" + port + "/books",List.class);
        assert(bookRequests != null);
    }

    @Test
    public void testCreateBook(){
        BookRequest dto1 = new BookRequest();
        dto1.setBookNumber(1234);
        dto1.setTitle("Java Basics");
        dto1.setAuthor("John Doe");
        dto1.setPublication_date("08/15/2020");
        dto1.setAvailable(false);
        ResponseEntity<BookRequest> bookRequest = this.restTemplate.postForEntity("http://localhost:" + port + "/books",dto1,BookRequest.class);
        assert(bookRequest.getStatusCodeValue() == 200 && bookRequest.getBody().getBookNumber() == 1234 && bookRequest.getBody().getId() > 0);
    }
}
