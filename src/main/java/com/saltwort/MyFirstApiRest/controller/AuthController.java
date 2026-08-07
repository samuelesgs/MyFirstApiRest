package com.saltwort.MyFirstApiRest.controller;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.dto.response.ApiResponse;
import com.saltwort.MyFirstApiRest.service.AuthService;
import com.saltwort.MyFirstApiRest.service.results.LoginResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ApiResponse<LoginResult> login(@Valid @RequestBody LoginRequestDto bodyParams) {
        LoginResult result = this.authService.login(bodyParams);
        if (result == null) {
            return ApiResponse.error("Invalid username or password", 401);
        }
        return ApiResponse.success(result);
    }

}