package com.example.trackWise.controller;

import com.example.trackWise.dto.NotificationDTO;
import com.example.trackWise.mapper.NotificationMapper;
import com.example.trackWise.model.User;
import com.example.trackWise.service.NotificationService;
import com.example.trackWise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final UserService userService;
    private final NotificationMapper notificationMapper;

    @GetMapping("/{email}")
    public ResponseEntity<List<NotificationDTO>> getUnreadNotifications(@PathVariable String email) {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        List<NotificationDTO> notifications = notificationService.getUnreadNotifications(user).stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notifications);
    }
}