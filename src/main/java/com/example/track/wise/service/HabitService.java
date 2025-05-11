package com.example.track.wise.service;

import com.example.track.wise.model.Habit;
import com.example.track.wise.model.User;

import java.util.List;
import java.util.Optional;

public interface HabitService {
    List<Habit> getUserHabits(User user);
    Optional<Habit> getHabitById(Long id);
    Habit saveHabit(Habit habit);
    void deleteHabit(Long habitId);
}
