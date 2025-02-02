package com.example.trackWise.service.impl;

import com.example.trackWise.model.Habit;
import com.example.trackWise.model.HabitProgress;
import com.example.trackWise.repository.HabitProgressRepository;
import com.example.trackWise.service.HabitProgressService;
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
