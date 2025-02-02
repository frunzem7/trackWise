package com.example.trackWise.repository;

import com.example.trackWise.model.Habit;
import com.example.trackWise.model.HabitProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HabitProgressRepository extends JpaRepository<HabitProgress, Long> {
    List<HabitProgress> findByHabitAndDateBetween(Habit habit, LocalDate startDate, LocalDate endDate);
}