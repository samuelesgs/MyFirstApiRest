package com.saltwort.MyFirstApiRest.controller;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.service.AuthService;
import com.saltwort.MyFirstApiRest.service.results.LoginResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequestDto bodyParams) {
        LoginResult result = this.authService.login(bodyParams);
        if (result == null) {
            return "Login failed";
        }
        System.out.println(result.user());
        return "Login successful!";
    }

}