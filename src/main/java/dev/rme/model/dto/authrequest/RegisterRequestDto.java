package dev.rme.model.dto.authrequest;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String password;
    private String email;
}
