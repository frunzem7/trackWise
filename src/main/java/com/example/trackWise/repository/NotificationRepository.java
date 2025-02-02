package com.example.trackWise.repository;

import com.example.trackWise.model.Notification;
import com.example.trackWise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserAndReadFalse(User user);
}