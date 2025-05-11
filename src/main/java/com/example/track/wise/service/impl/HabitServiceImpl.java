package com.example.track.wise.service.impl;


import com.example.track.wise.model.Habit;
import com.example.track.wise.model.User;
import com.example.track.wise.repository.HabitRepository;
import com.example.track.wise.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {
    private final HabitRepository habitRepository;

    @Override
    public List<Habit> getUserHabits(User user) {
        return habitRepository.findByUser(user);
    }

    @Override
    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    @Override
    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public void deleteHabit(Long habitId) {
        habitRepository.deleteById(habitId);
    }
}
