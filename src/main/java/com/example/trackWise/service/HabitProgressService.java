package com.example.trackWise.service;

import com.example.trackWise.model.Habit;
import com.example.trackWise.model.HabitProgress;

import java.time.LocalDate;
import java.util.List;

public interface HabitProgressService {
    List<HabitProgress> getProgressForHabit(Habit habit, LocalDate startDate, LocalDate endDate);
    HabitProgress logProgress(Habit habit, LocalDate date, boolean completed);
}