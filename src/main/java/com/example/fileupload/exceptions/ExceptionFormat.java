package com.example.fileupload.exceptions;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
public class ExceptionFormat {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime timestamp;
    private String message;
    private String description;

    private  ExceptionFormat() {
        timestamp = LocalDateTime.now();
    }

    public  ExceptionFormat(HttpStatus status, String message, Throwable ex) {
        this();
        System.out.println("Exceptio is generating");
        this.status = status;
        this.message = message;
        if(ex != null) {
            this.description = ex.getLocalizedMessage();
        }
    }
}
