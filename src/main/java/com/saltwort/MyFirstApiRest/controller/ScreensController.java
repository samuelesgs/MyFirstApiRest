package com.saltwort.MyFirstApiRest.controller;

import com.saltwort.MyFirstApiRest.dto.response.ApiResponse;
import com.saltwort.MyFirstApiRest.dto.response.ScreenHomeDto;
import com.saltwort.MyFirstApiRest.service.ScreenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/screens")
public class ScreensController {

    private final ScreenService screenService;

    public ScreensController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/home/{idUser}")
    public ApiResponse<ScreenHomeDto> getHomeScreen(@PathVariable Long idUser) {
        ScreenHomeDto result =  screenService.getHomeScreen(idUser);
        return ApiResponse.success(result);
    }
}
