package dev.rme.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Error {
    private String code;
    private String message;
    private HttpStatus httpStatus;
}
