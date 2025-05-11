package com.example.track.wise.controller;

import com.example.track.wise.mapper.NotificationMapper;
import com.example.track.wise.model.User;
import com.example.track.wise.dto.NotificationDTO;
import com.example.track.wise.service.NotificationService;
import com.example.track.wise.service.UserService;
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