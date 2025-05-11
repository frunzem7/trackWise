package com.example.track.wise.service.impl;

import com.example.track.wise.model.Notification;
import com.example.track.wise.model.User;
import com.example.track.wise.repository.NotificationRepository;
import com.example.track.wise.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> getUnreadNotifications(User user) {
        return notificationRepository.findByUserAndReadFalse(user);
    }

    @Override
    public Notification sendNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setRead(false);
        notification.setCreatedAt(java.time.LocalDateTime.now());
        return notificationRepository.save(notification);
    }
}