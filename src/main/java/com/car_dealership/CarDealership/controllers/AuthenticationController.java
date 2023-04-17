package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

}
