package com.example.libraryapi.aop;

import com.example.libraryapi.exception.BusinessException;
import com.example.libraryapi.exception.ErrorInfo;
import com.example.libraryapi.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({
            BusinessException.class,
            IllegalArgumentException.class,
    })
    public ResponseEntity<ErrorInfo> handleIllegalException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorInfo(ex.getMessage(), 400));
    }

    @ExceptionHandler({
            ResourceNotFoundException.class
    })
    public ResponseEntity<ErrorInfo> handleResourceNotFoundException(RuntimeException ex) {
        return ResponseEntity
                .status(404)
                .body(new ErrorInfo(ex.getMessage(), 404));
    }
}
