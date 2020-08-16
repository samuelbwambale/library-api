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
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookRequest {
    private Long id;

    @NotNull(message = "Book number is requireds")
//    @Size(min = 4, max = 4)
    @Range(min = 1, max = 9999)
    private Integer bookNumber;

    @NotNull
    @Size(min = 2)
    private String title;

    @NotNull
    @Size(min = 2)
    private String author;

    @NotNull
    private String publication_date;

    private boolean available;
}
