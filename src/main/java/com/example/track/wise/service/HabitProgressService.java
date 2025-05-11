package com.example.track.wise.service;

import com.example.track.wise.model.Habit;
import com.example.track.wise.model.HabitProgress;

import java.time.LocalDate;
import java.util.List;

public interface HabitProgressService {
    List<HabitProgress> getProgressForHabit(Habit habit, LocalDate startDate, LocalDate endDate);
    HabitProgress logProgress(Habit habit, LocalDate date, boolean completed);
}