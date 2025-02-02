package com.example.trackWise.service;

import com.example.trackWise.model.Habit;
import com.example.trackWise.model.User;

import java.util.List;
import java.util.Optional;

public interface HabitService {
    List<Habit> getUserHabits(User user);
    Optional<Habit> getHabitById(Long id);
    Habit saveHabit(Habit habit);
    void deleteHabit(Long habitId);
}
