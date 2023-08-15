package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.LoginRequestDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exception.ApiError;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.LoginService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(LoginRequestDto loginRequestDto) {
        User userByEmail = userService.getByEmail(loginRequestDto.getEmail());

        if (userByEmail == null || !passwordEncoder.matches(loginRequestDto.getPassword(), userByEmail.getPassword())) {
            throw ApiError.unauthorized("Bad credentials");
        }

        return userByEmail;
    }
}
