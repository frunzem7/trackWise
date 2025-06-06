package com.example.track.wise.repository;

import com.example.track.wise.model.Notification;
import com.example.track.wise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserAndReadFalse(User user);
}