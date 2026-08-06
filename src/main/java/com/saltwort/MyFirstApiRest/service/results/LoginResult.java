package com.saltwort.MyFirstApiRest.service.results;

import com.saltwort.MyFirstApiRest.dto.response.UserDto;

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
