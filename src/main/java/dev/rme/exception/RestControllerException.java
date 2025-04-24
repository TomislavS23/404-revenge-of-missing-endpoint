package dev.rme.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestControllerException extends RuntimeException {
    private final transient String message;
    private final transient HttpStatus httpStatus;

    public RestControllerException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
