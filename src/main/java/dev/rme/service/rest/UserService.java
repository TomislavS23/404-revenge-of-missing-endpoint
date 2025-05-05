package dev.rme.service.rest;

import dev.rme.error.ErrorProperties;
import dev.rme.error.ErrorResponseBuilder;
import dev.rme.exception.RestControllerException;
import dev.rme.model.database.User;
import dev.rme.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ErrorProperties errorProperties;
    private final ErrorResponseBuilder errorResponseBuilder;

    public List<User> findAllUsers() {
        return userRepository.findAllUsers()
                .orElseThrow(() -> new RestControllerException(errorResponseBuilder.build(errorProperties.getError())));
    }

    public User findUserById(Integer id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new RestControllerException(errorResponseBuilder.build(errorProperties.getError())));
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new RestControllerException(errorResponseBuilder.build(errorProperties.getError())));
    }

    public void updateUser(String username, String email, Integer id) {
        try {
            userRepository.update(username, email, id);
        } catch (RestControllerException e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getError()));
        }
    }

    public void changePassword(byte[] password, byte[] salt, String username) {
        try {
            userRepository.changePassword(password, salt, username);
        } catch (RestControllerException e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getError()));
        }
    }

    public void deleteUser(Integer id) {
        try {
            userRepository.delete(id);
        } catch (RestControllerException e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getError()));
        }
    }

    public void insertUser(String username, byte[] password, byte[] salt, String email) {
        try {
            userRepository.insert(username, password, salt, email);
        } catch (RestControllerException e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getError()));
        }
    }
}
