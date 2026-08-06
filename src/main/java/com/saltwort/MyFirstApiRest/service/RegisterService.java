package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.dto.request.RegisterRequestDto;
import com.saltwort.MyFirstApiRest.model.ConvertEntitiesDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.repository.AuthRepository;
import com.saltwort.MyFirstApiRest.repository.RegisterRepository;
import com.saltwort.MyFirstApiRest.service.results.RegisterResultComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final AuthRepository authRepository;
    private final ConvertEntitiesDto convertEntitiesDto;

    @Autowired
    public RegisterService(RegisterRepository registerRepository, AuthRepository authRepository, ConvertEntitiesDto convertEntitiesDto) {
        this.registerRepository = registerRepository;
        this.authRepository = authRepository;
        this.convertEntitiesDto = convertEntitiesDto;
    }


    public RegisterResultComplete register(RegisterRequestDto bodyParams) {
        LoginRequestDto loginRequestDto = this.convertEntitiesDto.constructAuthenticationDto(bodyParams.getEmail(),bodyParams.getPassword());
        boolean isAuthenticated = authRepository.authenticate(loginRequestDto);
        if (isAuthenticated) {
            return null;
        }
        User user = authRepository.registerUser(
                this.convertEntitiesDto.constructUserEntity(
                        bodyParams.getEmail(),
                        bodyParams.getPassword(),
                        bodyParams.getName(),
                        bodyParams.getType())
        );
        return  registerRepository.register(user);

    }
}
