package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.dto.AuthenticationDto;
import com.car_dealership.CarDealership.dto.UserDto;
import com.car_dealership.CarDealership.models.User;
import com.car_dealership.CarDealership.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/users/sign-up")
    public UserDto addUser(@RequestBody User user) {
        userService.registerUser(user);
        UserDto userDto = UserDto.DtoFromUser(user);
        return userDto;
    }

    @PostMapping("/users/login")
    public String loginUser(@RequestBody AuthenticationDto authenticationDto) {
        String email = authenticationDto.getEmail();
        User user = userService.findByEmail(email);

        if (passwordEncoder.matches(authenticationDto.getPassword(), user.getPassword())) {
            return "successful";
        }
        return "no such user";
    }

}
