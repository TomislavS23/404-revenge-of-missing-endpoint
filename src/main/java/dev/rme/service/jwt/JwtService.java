package dev.rme.service.jwt;

import dev.rme.model.Role;
import dev.rme.model.dto.authrequest.JwtTokenDto;
import dev.rme.utils.Constants;
import dev.rme.utils.security.Secrets;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.xml.bind.DatatypeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final Secrets secrets;

    public JwtTokenDto generateJwtTokens(String username, Claims claims) {
        var accessToken = generateJwtToken(username, claims, Constants.ACCESS_TOKEN_TTL);
        var refreshToken = generateJwtToken(username, claims, Constants.REFRESH_TOKEN_TTL);

        return new JwtTokenDto(accessToken, refreshToken);
    }

    public String generateJwtToken(String username, Claims claims, Long ttl) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(getTimestamp())
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

    }

    public Boolean validateJwtToken(String token) {
        if (token != null) {
            var claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        }
        return false;
    }

    public String refreshJwtToken(String token) {
        var claims = extractAllClaims(token);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(getTimestamp())
                .setSubject(claims.getSubject())
                .setExpiration(new Date(System.currentTimeMillis() + Constants.ACCESS_TOKEN_TTL))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secrets.getJWT_SECRET_KEY()))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Claims generateClaims(String subject, Role role) {
        var claims = Jwts.claims();
        claims.setSubject(subject);
        claims.add("authorities", List.of("ROLE_" + role.getName()));

        return claims.build();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secrets.getJWT_SECRET_KEY());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Date getTimestamp() {
        var nowMillis = System.currentTimeMillis();
        return new Date(nowMillis);
    }
}