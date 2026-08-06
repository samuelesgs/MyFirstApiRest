package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import com.saltwort.MyFirstApiRest.model.User;

public class LoginResult {
    private final UserDto user;
    private final String token;

    public LoginResult(UserDto user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserDto user() {
        return user;
    }

    public String token() {
        return token;
    }
}
