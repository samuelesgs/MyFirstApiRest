package com.saltwort.MyFirstApiRest.repository;

import com.saltwort.MyFirstApiRest.model.ConvertEntitiesDto;
import com.saltwort.MyFirstApiRest.model.List;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.model.UserConfiguration;
import com.saltwort.MyFirstApiRest.service.ListService;
import com.saltwort.MyFirstApiRest.service.UserConfigurationService;
import com.saltwort.MyFirstApiRest.service.UserService;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

@Repository
public class ScreensRepository {

    private final ListService listService;
    private final UserConfigurationService userConfigurationService;
    private final UserService userService;


    public ScreensRepository(ListService listService, UserConfigurationService userConfigurationService, UserService userService) {
        this.listService = listService;
        this.userService = userService;
        this.userConfigurationService = userConfigurationService;
    }

    public User findUserById(Long idUser) {
        return userService.findById(idUser);
    }

    public UserConfiguration findConfigurationByUserId(Long idUser) {
        return userConfigurationService.findByUserId(idUser);
    }

    public List[] findListsByUserId(Long idUser) {
        return listService.findByUserId(idUser);
    }
}
