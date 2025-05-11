package com.example.track.wise.service;

import com.example.track.wise.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);

    User registerUser(String email, String password);
}
