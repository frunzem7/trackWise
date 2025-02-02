package com.example.trackWise.service;

import com.example.trackWise.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);

    User registerUser(String email, String password);
}
