package com.saltwort.MyFirstApiRest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
    private String token;
    private int keyId;
    private String keyEmail;
}
