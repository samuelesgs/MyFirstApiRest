package com.saltwort.MyFirstApiRest.repository;

import com.saltwort.MyFirstApiRest.dto.response.ListDto;
import com.saltwort.MyFirstApiRest.model.ConvertEntitiesDto;
import com.saltwort.MyFirstApiRest.model.List;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.model.UserConfiguration;
import com.saltwort.MyFirstApiRest.service.JwtService;
import com.saltwort.MyFirstApiRest.service.ListService;
import com.saltwort.MyFirstApiRest.service.UserConfigurationService;
import com.saltwort.MyFirstApiRest.service.results.RegisterResultComplete;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository {
    private final JwtService jwtService;
    private final UserConfigurationService userConfigurationService;
    private final ConvertEntitiesDto convertEntitiesDto;
    private final ListService listService;


    public RegisterRepository(
            JwtService jwtService,
            UserConfigurationService userConfigurationService,
            ListRepository listRepository,
            ConvertEntitiesDto convertEntitiesDto,
            ListService listService
    ) {
        this.jwtService = jwtService;
        this.userConfigurationService = userConfigurationService;
        this.convertEntitiesDto = convertEntitiesDto;
        this.listService = listService;
    }

    public RegisterResultComplete register(User user) {
        UserConfiguration userConfiguration = this.userConfigurationService.save(
                this.convertEntitiesDto.constructUserConfigurationEntity(user));
        List list  = this.listService.save(this.convertEntitiesDto.defaultListEntity("List 1", "First list", user));
        List list2 = this.listService.save(this.convertEntitiesDto.defaultListEntity("List 2", "Second list", user));
        List list3 = this.listService.save(this.convertEntitiesDto.defaultListEntity("List 3", "Third list", user));

        ListDto[] array = new ListDto[3];
        array[0] = this.convertEntitiesDto.constructListDto(list);
        array[1] = this.convertEntitiesDto.constructListDto(list2);
        array[2] = this.convertEntitiesDto.constructListDto(list3);

        return new RegisterResultComplete(
                this.convertEntitiesDto.constructUserDto(user),
                this.convertEntitiesDto.constructUserConfigurationDto(userConfiguration),
                array
        );
    }
}
