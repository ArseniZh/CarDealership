package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.dto.UserDto;
import com.car_dealership.CarDealership.models.User;
import com.car_dealership.CarDealership.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable("id") User user) {
        UserDto userDto = UserDto.DtoFromUser(user);
        return userDto;
    }

    @PostMapping("/users/sign-up")
    public UserDto addUser(@RequestBody User user) {
        userService.registerUser(user);
        UserDto userDto = UserDto.DtoFromUser(user);
        return userDto;
    }
}
