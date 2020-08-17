package com.example.libraryapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResourceNotFoundException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
