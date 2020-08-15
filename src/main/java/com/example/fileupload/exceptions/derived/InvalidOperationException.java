package com.example.fileupload.exceptions.derived;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException() {
        this("Invalid Operation");
    }

    public InvalidOperationException(String message) {
        super(message);
    }
}
