package com.example.libraryapi.dto.book;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookRequest {
    private Long id;

    @NotNull(message = "Book number is required")
    @Range(min = 1, max = 9999, message = "Book number should be a 4-digit number")
    private Integer bookNumber;

    @NotNull(message = "Book title is required")
    @Size(min = 2)
    private String title;

    @NotNull(message = "Book author is required")
    @Size(min = 2)
    private String author;

    @NotNull(message = "Book publication date is required")
    @NotBlank(message = "Book publication date is required")
    private String publication_date;

    @NotNull(message = "Book availability is required")
    private boolean available;
}
