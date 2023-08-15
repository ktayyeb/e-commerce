package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User getByName(String name);

    User getByEmail(String email);

    User save(User user);
}
