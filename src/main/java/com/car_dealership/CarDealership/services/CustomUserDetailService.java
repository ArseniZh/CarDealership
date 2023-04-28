package com.car_dealership.CarDealership.services;

import com.car_dealership.CarDealership.models.Role;
import com.car_dealership.CarDealership.models.User;
import com.car_dealership.CarDealership.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        String[] roleNames = user.getUserRoles().stream().map(Role::getName).toArray(String[]::new);
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword())
                .roles(roleNames).build();
    }
}
