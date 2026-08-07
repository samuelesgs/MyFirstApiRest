package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.response.ScreenHomeDto;
import com.saltwort.MyFirstApiRest.model.ConvertEntitiesDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.model.UserConfiguration;
import com.saltwort.MyFirstApiRest.repository.ScreensRepository;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    private final ConvertEntitiesDto convertEntitiesDto;
    private final ScreensRepository screensRepository;

    public ScreenService(ScreensRepository screensRepository, ConvertEntitiesDto convertEntitiesDto) {
        this.screensRepository = screensRepository;
        this.convertEntitiesDto = convertEntitiesDto;
    }

    public ScreenHomeDto getHomeScreen(Long idUser) {
        ScreenHomeDto screenHomeDto = new ScreenHomeDto();
        User user = this.screensRepository.findUserById(idUser);
        if (user == null) {
            return null;
        }
        screenHomeDto.setUser(this.convertEntitiesDto.constructUserDto(user));
        UserConfiguration userConfiguration = this.screensRepository.findConfigurationByUserId(idUser);
        screenHomeDto.setUserConfiguration(this.convertEntitiesDto.constructUserConfigurationDto(userConfiguration));
        screenHomeDto.setLists(this.convertEntitiesDto.constructListDtoArray(this.screensRepository.findListsByUserId(idUser)));
        return screenHomeDto;
    }

}
