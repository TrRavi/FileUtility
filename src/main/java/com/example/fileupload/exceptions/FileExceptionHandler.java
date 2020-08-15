package com.example.fileupload.exceptions;

import com.example.fileupload.exceptions.derived.InvalidOperationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class FileExceptionHandler {

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<Object> handleInvalidOperationException(InvalidOperationException exception) {
        return new ResponseEntity<>(new ExceptionFormat(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
