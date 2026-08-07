package com.saltwort.MyFirstApiRest.model;

import com.saltwort.MyFirstApiRest.dto.request.LoginRequestDto;
import com.saltwort.MyFirstApiRest.dto.response.ListDto;
import com.saltwort.MyFirstApiRest.dto.response.UserConfigurationDto;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import com.saltwort.MyFirstApiRest.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConvertEntitiesDto {
    private final UserRepository userRepository;

    public ConvertEntitiesDto(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginRequestDto constructAuthenticationDto(String email, String password) {
        return new LoginRequestDto(
                email,
                password,
                1L
        );
    }

    public User constructUserEntity(String email, String password, String name, Long type) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setType(type);
        user.setDateInsert(LocalDateTime.now());
        user.setDateUpdate(LocalDateTime.now());
        return user;
    }

    public UserConfiguration constructUserConfigurationEntity(User user) {
        UserConfiguration userConfiguration = new UserConfiguration();
        userConfiguration.setUser(user);
        userConfiguration.setTheme(1L);
        userConfiguration.setLanguage(1L);
        userConfiguration.setNotification(1L);
        return userConfiguration;
    }

    public List constructListEntity(ListDto record) {
        List list = new List();
        list.setName(record.getName());
        list.setDetail(record.getDetail());
        list.setDisabled(record.getDisabled());
        list.setPriority(record.getPriority());
        list.setShowAmount(record.getShowAmount());
        list.setShowHome(record.getShowHome());
        User user = userRepository.findById(record.getFkUser()).orElse(null);
        list.setUser(user);
        list.setDateInsert(LocalDateTime.now());
        list.setDateUpdate(LocalDateTime.now());
        return list;
    }

    public List defaultListEntity(String name, String detail, User user) {
        List list = new List();
        list.setName(name);
        list.setDetail(detail);
        list.setDisabled(1L);
        list.setPriority(1L);
        list.setShowAmount(1L);
        list.setShowHome(1L);
        list.setUser(user);
        list.setDateInsert(LocalDateTime.now());
        list.setDateUpdate(LocalDateTime.now());
        return list;
    }

    public UserDto constructUserDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getName(), user.getType());
    }

    public UserConfigurationDto constructUserConfigurationDto(UserConfiguration userConfiguration) {
        return new UserConfigurationDto(
                userConfiguration.getId(),
                userConfiguration.getUser().getId(),
                userConfiguration.getTheme(),
                userConfiguration.getLanguage(),
                userConfiguration.getNotification()
        );
    }

    public ListDto constructListDto(List list) {
        return new ListDto(
                list.getDetail(),
                list.getDisabled(),
                list.getName(),
                list.getPriority(),
                list.getShowAmount(),
                list.getShowHome(),
                list.getUser().getId()
        );
    }
}
