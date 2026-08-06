package com.saltwort.MyFirstApiRest.service.results;

import com.saltwort.MyFirstApiRest.dto.response.ListDto;
import com.saltwort.MyFirstApiRest.dto.response.UserConfigurationDto;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResultComplete {
    private UserDto user;
    private UserConfigurationDto userConfiguration;
    private ListDto[] lists;
}
