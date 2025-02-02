package com.example.trackWise.service;

import com.example.trackWise.model.Notification;
import com.example.trackWise.model.User;

import java.util.List;

public interface NotificationService {
    List<Notification> getUnreadNotifications(User user);
    Notification sendNotification(User user, String message);
}
