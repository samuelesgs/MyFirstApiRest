package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.request.RegisterRequestDto;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.repository.AuthRepository;
import com.saltwort.MyFirstApiRest.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    public UserService(AuthRepository authRepository, UserRepository userRepository) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
    }

    private UserDto insertUser(RegisterRequestDto bodyParams) {
        User userModel = new User();
        userModel.setEmail(bodyParams.getEmail());
        userModel.setName(bodyParams.getName());
        userModel.setType(bodyParams.getType());
        userModel.setDateInsert(LocalDateTime.now());
        userModel.setDateUpdate(LocalDateTime.now());
        userModel.setPassword(authRepository.encryptValue(bodyParams.getPassword()));
        User user = userRepository.save(userModel);
        return new UserDto(user.getId(), user.getEmail(), user.getName(), user.getType());
    }

    public User findById(Long fkUser) {
        return userRepository.findById(fkUser).orElse(null);
    }

    public User updatePassword(Long id, String newPassword) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPassword(authRepository.encryptValue(newPassword));
            user.setDateUpdate(LocalDateTime.now());
            return userRepository.save(user);
        }
        return null;
    }

    public User updateUser(Long id, UserDto bodyParams) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(bodyParams.getName());
            user.setDateUpdate(LocalDateTime.now());
            return userRepository.save(user);
        }
        return null;
    }
}
