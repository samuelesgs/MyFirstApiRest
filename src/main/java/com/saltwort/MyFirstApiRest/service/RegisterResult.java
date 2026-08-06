package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.response.UserDto;

public class RegisterResult {
    private final UserDto user;

    public RegisterResult(UserDto user) {
        this.user = user;
    }
}
