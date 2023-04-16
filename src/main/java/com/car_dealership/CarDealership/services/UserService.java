package com.car_dealership.CarDealership.services;

import com.car_dealership.CarDealership.models.Role;
import com.car_dealership.CarDealership.models.User;
import com.car_dealership.CarDealership.repositories.RoleRepository;
import com.car_dealership.CarDealership.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        Role role = roleRepository.findByName("User");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRoles(roles);
        User newUser = userRepository.save(user);
        return newUser;
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
