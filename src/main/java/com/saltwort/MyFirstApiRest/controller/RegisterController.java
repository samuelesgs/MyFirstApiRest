package com.saltwort.MyFirstApiRest.controller;

import com.saltwort.MyFirstApiRest.dto.request.RegisterRequestDto;
import com.saltwort.MyFirstApiRest.dto.response.ApiResponse;
import com.saltwort.MyFirstApiRest.service.RegisterService;
import com.saltwort.MyFirstApiRest.service.results.RegisterResultComplete;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    private final RegisterService register;

    public RegisterController(RegisterService register) {
        this.register = register;
    }


    @PostMapping("/new-user")
    public ApiResponse<RegisterResultComplete> register(@Valid @RequestBody RegisterRequestDto bodyParams) {
        RegisterResultComplete result = this.register.register(bodyParams);
        if (result == null) {
            return ApiResponse.error("Registration failed", 400);
        }
        return ApiResponse.success(result);
    }
}
