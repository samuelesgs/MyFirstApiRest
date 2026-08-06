package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.repository.AuthRepository;
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
        System.out.println("Auth service, login");
        boolean isAuthenticated = authRepository.authenticate(bodyParams);
        System.out.println("authenticated: " + isAuthenticated);
        if (isAuthenticated) {
            return this.authRepository.loginSuccessfully(bodyParams.getEmail());
        }
        System.out.println("Retorno null");
        return null;
    }
}
