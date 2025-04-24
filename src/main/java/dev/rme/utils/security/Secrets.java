package dev.rme.utils.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Secrets {
    @Value("${jwt.secret.key}")
    private String JWT_SECRET_KEY;
}
