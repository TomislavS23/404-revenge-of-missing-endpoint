package dev.rme.model.dto.authrequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangePasswordDto {
    private String username;
    private String oldPassword;
    private String newPassword;
}
