package com.example.track.wise.repository;

import com.example.track.wise.model.Habit;
import com.example.track.wise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    List<Habit> findByUser(User user);
}