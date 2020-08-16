package com.example.libraryapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(length = 4, nullable = false)
    @Size(min = 4, max = 4)
    private Integer bookNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Temporal(TemporalType.TIME)
    private Date publication_date;

    private boolean available;

}
