package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.dto.AuthenticationDto;
import com.car_dealership.CarDealership.dto.UserDto;
import com.car_dealership.CarDealership.models.User;
import com.car_dealership.CarDealership.services.CustomUserDetailService;
import com.car_dealership.CarDealership.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;
    private CustomUserDetailService userDetailService;

    @PostMapping("/users/sign-up")
    public UserDto addUser(@RequestBody User user) {
        userService.registerUser(user);
        UserDto userDto = UserDto.createDtoFromUser(user);
        return userDto;
    }

    @PostMapping("/users/login")
    public UserDetails loginUser(@RequestBody AuthenticationDto authenticationDto) {
        String email = authenticationDto.getEmail();
        User user = userService.findByEmail(email);

        if (user != null && passwordEncoder.matches(authenticationDto.getPassword(), user.getPassword())) {
            return userDetailService.loadUserByUsername(email);
        }
        return null;
    }
}
