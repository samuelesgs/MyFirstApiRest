package com.saltwort.MyFirstApiRest.service.results;

import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResult {
    private final UserDto user;
    private final String token;
}
