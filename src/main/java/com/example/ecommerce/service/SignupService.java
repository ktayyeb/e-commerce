package com.example.ecommerce.service;

import com.example.ecommerce.dto.SignupRequestDto;
import com.example.ecommerce.entity.User;

public interface SignupService {
    User signup(SignupRequestDto signupRequestDto);
}
