package com.car_dealership.CarDealership.controllers;

import com.car_dealership.CarDealership.dto.UserDto;
import com.car_dealership.CarDealership.models.User;
import com.car_dealership.CarDealership.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.car_dealership.CarDealership.dto.UserDto.createDtoFromUser;

@RestController
@AllArgsConstructor
public class AdminController {
    private UserService userService;

    @GetMapping("/admin/users/{id}")
    public UserDto getUserById(@PathVariable("id") User user) {
        UserDto userDto = createDtoFromUser(user);
        return userDto;
    }

    @GetMapping("/admin/users")
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAll();

        return users.stream().map(user -> createDtoFromUser(user)).collect(Collectors.toList());
    }

    @DeleteMapping("/admin/users/{id}")
    public void deleteUser(@PathVariable("id") User user) {
        userService.deleteUser(user);
    }

    @PostMapping("/admin/users")
    public UserDto createUser(@RequestBody User user) {
        return createDtoFromUser(userService.registerUser(user));
    }
}
