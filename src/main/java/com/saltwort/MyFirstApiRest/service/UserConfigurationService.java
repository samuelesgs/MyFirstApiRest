package com.saltwort.MyFirstApiRest.service;

import com.saltwort.MyFirstApiRest.dto.response.UserConfigurationDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.model.UserConfiguration;
import com.saltwort.MyFirstApiRest.repository.UserConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
public class UserConfigurationService {

    private final UserConfigurationRepository userConfigurationRepository;
    private final UserService userService;

    public UserConfigurationService(UserConfigurationRepository userConfigurationRepository, UserService userService) {
        this.userConfigurationRepository = userConfigurationRepository;
        this.userService = userService;
    }

    public UserConfiguration save(UserConfiguration userConfiguration) {
        return userConfigurationRepository.save(userConfiguration);
    }

    public UserConfiguration insert(UserConfigurationDto userConfigurationDto) {
        User user = userService.findById(userConfigurationDto.getFkUser());
        UserConfiguration userConfiguration = new UserConfiguration();
        userConfiguration.setUser(user);
        userConfiguration.setTheme(userConfigurationDto.getTheme());
        userConfiguration.setLanguage(userConfigurationDto.getLanguage());
        return this.save(userConfiguration);
    }


    public UserConfiguration findByUserId(Long fkUser) {
        return userConfigurationRepository.findByUserId(fkUser).orElse(null);
    }
}
