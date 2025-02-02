package com.example.trackWise.repository;

import com.example.trackWise.model.Habit;
import com.example.trackWise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    List<Habit> findByUser(User user);
}