package com.saltwort.MyFirstApiRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenHomeDto {
    private UserDto user;
    private ListDto[] lists;
    private UserConfigurationDto userConfiguration;
    private RecordDto[] records;
}
