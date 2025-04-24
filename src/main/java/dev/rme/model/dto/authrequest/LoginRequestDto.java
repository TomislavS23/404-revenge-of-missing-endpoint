package dev.rme.model.dto.authrequest;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
