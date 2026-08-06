package com.saltwort.MyFirstApiRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserConfigurationDto {
    private int id;
    private int theme;
    private int language;
    private int notification;
}
