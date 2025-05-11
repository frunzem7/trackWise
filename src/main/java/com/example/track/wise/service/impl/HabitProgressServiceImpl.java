package com.example.track.wise.service.impl;

import com.example.track.wise.model.Habit;
import com.example.track.wise.model.HabitProgress;
import com.example.track.wise.repository.HabitProgressRepository;
import com.example.track.wise.service.HabitProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitProgressServiceImpl implements HabitProgressService {
    private final HabitProgressRepository habitProgressRepository;

    @Override
    public List<HabitProgress> getProgressForHabit(Habit habit, LocalDate startDate, LocalDate endDate) {
        return habitProgressRepository.findByHabitAndDateBetween(habit, startDate, endDate);
    }

    @Override
    public HabitProgress logProgress(Habit habit, LocalDate date, boolean completed) {
        HabitProgress progress = new HabitProgress();
        progress.setHabit(habit);
        progress.setDate(date);
        progress.setCompleted(completed);
        return habitProgressRepository.save(progress);
    }
}
