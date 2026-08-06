package com.saltwort.MyFirstApiRest.repository;

import com.saltwort.MyFirstApiRest.config.AppConstants;
import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.service.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import com.saltwort.MyFirstApiRest.service.JwtService;

import java.util.Optional;


@Repository
public class AuthRepository {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Autowired
    public AuthRepository(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public boolean authenticate(LoginRequestDto dto) {
        Optional<User> result = userRepository.findByEmail(dto.getEmail());
        return dto.getTypeLogin() != AppConstants.LOGIN_SERVICE_ACTIVE ? result
                .map(user -> passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                .orElse(false) : result.isPresent();
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public LoginResult loginSuccessfully(String email) {
        User user = findUserByEmail(email);
        String token = this.jwtService.generateToken(user.getId(), email);
        UserDto userDto = new UserDto(user.getId(), email, user.getName(), user.getType());
        return new LoginResult(userDto, token);
    }

    public String encryptValue(String value) {
        return jwtService.encryptValue(value);
    }

}
