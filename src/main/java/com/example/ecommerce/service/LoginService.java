package com.example.ecommerce.service;

import com.example.ecommerce.dto.LoginRequestDto;
import com.example.ecommerce.entity.User;

public interface LoginService {
    User login(LoginRequestDto loginRequestDto);
}
