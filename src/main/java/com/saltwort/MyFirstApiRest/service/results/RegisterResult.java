package com.saltwort.MyFirstApiRest.service.results;

import com.saltwort.MyFirstApiRest.dto.response.ListDto;
import com.saltwort.MyFirstApiRest.dto.response.UserConfigurationDto;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;

public class RegisterResult {
    private final UserDto user;
    private final UserConfigurationDto userConfigurationDto;
    private final ListDto[] list;

    public RegisterResult(UserDto user, UserConfigurationDto userConfigurationDto, ListDto[] list) {
        this.user = user;
        this.userConfigurationDto = userConfigurationDto;
        this.list = list;
    }
}
