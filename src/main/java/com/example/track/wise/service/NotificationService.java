package com.example.track.wise.service;

import com.example.track.wise.model.Notification;
import com.example.track.wise.model.User;

import java.util.List;

public interface NotificationService {
    List<Notification> getUnreadNotifications(User user);
    Notification sendNotification(User user, String message);
}
