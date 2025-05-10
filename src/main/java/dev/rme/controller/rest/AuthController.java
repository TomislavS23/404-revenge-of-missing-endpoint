package dev.rme.controller.rest;

import dev.rme.model.dto.authrequest.JwtTokenDto;
import dev.rme.model.dto.authrequest.LoginRequestDto;
import dev.rme.model.dto.authrequest.RegisterRequestDto;
import dev.rme.service.jwt.JwtService;
import dev.rme.service.rest.UserService;
import dev.rme.utils.security.Encryption;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/404rme/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtService jwtService;
    private final UserService userService;
    private final Encryption encryption;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JwtTokenDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        try {
            var user = userService.findUserByUsername(loginRequestDto.getUsername());
            var isPasswordValid = encryption.verifyKey(loginRequestDto.getPassword(), user.getHashedPassword(), user.getSalt());
            if (user == null || !isPasswordValid) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            var tokens = jwtService.generateJwtTokens(
                    user.getUsername(),
                    jwtService.generateClaims(user.getUsername(), user.getRole())
            );

            return ResponseEntity.status(HttpStatus.OK).body(tokens);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JwtTokenDto> register(@RequestBody RegisterRequestDto registerRequest) {
        try {
            userService.findUserByUsername(registerRequest.getUsername());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            var entry = encryption.deriveKey(registerRequest.getPassword());
            userService.insertUser(
                    registerRequest.getUsername(),
                    entry.getValue(),
                    entry.getKey(),
                    registerRequest.getEmail()
            );

            var newUser = userService.findUserByUsername(registerRequest.getUsername());

            var tokens = jwtService.generateJwtTokens(
                    newUser.getUsername(),
                    jwtService.generateClaims(newUser.getUsername(), newUser.getRole())
            );

            return ResponseEntity.status(HttpStatus.OK).body(tokens);
        }
    }
}
