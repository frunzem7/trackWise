package com.example.trackWise.controller;

import com.example.trackWise.dto.UserDTO;
import com.example.trackWise.mapper.UserMapper;
import com.example.trackWise.model.User;
import com.example.trackWise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestParam String email, @RequestParam String password) {
        User user = userService.registerUser(email, password);
        return ResponseEntity.ok(userMapper.toDTO(user));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(userMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}