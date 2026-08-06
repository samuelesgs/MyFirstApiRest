package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.dto.request.RegisterRequestDto;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.repository.AuthRepository;
import com.saltwort.MyFirstApiRest.repository.UserRepository;

public class UserService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    public UserService(AuthRepository authRepository, UserRepository userRepository) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
    }

    public RegisterResult register(RegisterRequestDto bodyParams) {
        LoginRequestDto loginRequestDto = new LoginRequestDto(
                bodyParams.getEmail(),
                bodyParams.getPassword(),
                1L
        );
        boolean verify = authRepository.authenticate(loginRequestDto);
        if (verify) {
            return null;
        }
        UserDto userDto = this.insertUser(bodyParams);
        return new RegisterResult(userDto);
    }


    private UserDto insertUser(RegisterRequestDto bodyParams) {
        User userModel = new User();
        userModel.setName(bodyParams.getName());
        userModel.setType(bodyParams.getType());
        userModel.setPassword(authRepository.encryptValue(bodyParams.getPassword()));
        User user = userRepository.save(userModel);
        return new UserDto(user.getId(), user.getEmail(), user.getName(), user.getType());
    }
}
