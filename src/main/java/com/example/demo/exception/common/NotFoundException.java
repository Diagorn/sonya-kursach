package com.example.demo.exception.common;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
