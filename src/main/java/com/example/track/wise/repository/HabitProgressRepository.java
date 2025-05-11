package com.example.track.wise.repository;

import com.example.track.wise.model.Habit;
import com.example.track.wise.model.HabitProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HabitProgressRepository extends JpaRepository<HabitProgress, Long> {
    List<HabitProgress> findByHabitAndDateBetween(Habit habit, LocalDate startDate, LocalDate endDate);
}