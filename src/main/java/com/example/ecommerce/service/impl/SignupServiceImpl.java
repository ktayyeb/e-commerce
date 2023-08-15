package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SignupRequestDto;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exception.ApiError;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.SignupService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SignupServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signup(SignupRequestDto signupRequestDto) {
        User userByEmail = userService.getByEmail(signupRequestDto.getEmail());

        if (userByEmail != null) {
            throw ApiError.badRequest("User with this email already exist, choose another email");
        }

        User user = new User(signupRequestDto.getName(),
                signupRequestDto.getEmail(),
                passwordEncoder.encode(signupRequestDto.getPassword())
        );

        return userService.save(user);
    }
}
