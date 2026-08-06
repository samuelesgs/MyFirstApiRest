package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.repository.AuthRepository;
import com.saltwort.MyFirstApiRest.service.results.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public LoginResult login(LoginRequestDto bodyParams) {
        boolean isAuthenticated = authRepository.authenticate(bodyParams);
        if (isAuthenticated) {
            return this.authRepository.loginSuccessfully(bodyParams.getEmail());
        }
        return null;
    }

}
