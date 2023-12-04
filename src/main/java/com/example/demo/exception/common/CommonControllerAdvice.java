package com.example.demo.exception.common;

import com.example.demo.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        ErrorResponse response = new ErrorResponse(e.getStatus().value(), e.getMessage());
        return ResponseEntity.status(e.getStatus().value()).body(response);
    }
}
