package dev.rme.exception;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestControllerException.class)
    public ResponseEntity<String> handleException(RestControllerException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }
}
