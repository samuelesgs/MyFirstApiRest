package com.saltwort.MyFirstApiRest.controller;

import com.saltwort.MyFirstApiRest.dto.request.RegisterRequestDto;
import com.saltwort.MyFirstApiRest.service.RegisterResult;
import com.saltwort.MyFirstApiRest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody RegisterRequestDto bodyParams) {
        RegisterResult result = userService.register(bodyParams);
        if (result == null) {
            return "User registration failed";
        }
        return "User registration successful!";
    }
}
