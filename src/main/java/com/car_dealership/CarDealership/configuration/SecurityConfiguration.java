package com.car_dealership.CarDealership.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/users/sign-up").permitAll()
                .requestMatchers("/users/login").permitAll()
                .requestMatchers("/admin/**").hasRole("Admin")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}