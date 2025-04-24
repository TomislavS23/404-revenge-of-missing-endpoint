package dev.rme.model.dto.authrequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtTokenDto
{
    private String accessToken;
    private String refreshToken;
}
