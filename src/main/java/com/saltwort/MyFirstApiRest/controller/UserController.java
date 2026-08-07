package com.saltwort.MyFirstApiRest.controller;

import com.saltwort.MyFirstApiRest.dto.response.ApiResponse;
import com.saltwort.MyFirstApiRest.dto.response.UserDto;
import com.saltwort.MyFirstApiRest.model.User;
import com.saltwort.MyFirstApiRest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/change-password/{id}")
    public ApiResponse<User> updatePassword(@PathVariable Long id, @Valid @RequestBody String password) {
        User result = userService.updatePassword(id, password);
        if (result == null) {
            return ApiResponse.error("Failed to update password", 400);
        }
        return ApiResponse.success(result);
    }

    @PutMapping("/update-user/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto bodyParams) {
        User user = this.userService.updateUser(id, bodyParams);
        if (user == null) {
            return ApiResponse.error("Failed to update user.", 400);
        }
        return ApiResponse.success(user);

    }
}
