package com.example.trackWise.controller;

import com.example.trackWise.dto.HabitProgressDTO;
import com.example.trackWise.mapper.HabitProgressMapper;
import com.example.trackWise.model.Habit;
import com.example.trackWise.model.HabitProgress;
import com.example.trackWise.service.HabitProgressService;
import com.example.trackWise.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/progress")
@RequiredArgsConstructor
public class HabitProgressController {
    private final HabitProgressService habitProgressService;
    private final HabitService habitService;
    private final HabitProgressMapper habitProgressMapper;

    @GetMapping("/{habitId}")
    public ResponseEntity<List<HabitProgressDTO>> getProgress(@PathVariable Long habitId,
                                                              @RequestParam LocalDate startDate,
                                                              @RequestParam LocalDate endDate) {
        Habit habit = habitService.getHabitById(habitId).orElseThrow(() -> new RuntimeException("Habit not found"));
        List<HabitProgressDTO> progress = habitProgressService.getProgressForHabit(habit, startDate, endDate).stream()
                .map(habitProgressMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(progress);
    }

    @PostMapping("/{habitId}")
    public ResponseEntity<HabitProgressDTO> logProgress(@PathVariable Long habitId,
                                                        @RequestParam LocalDate date,
                                                        @RequestParam boolean completed) {
        Habit habit = habitService.getHabitById(habitId).orElseThrow(() -> new RuntimeException("Habit not found"));
        HabitProgress progress = habitProgressService.logProgress(habit, date, completed);
        return ResponseEntity.ok(habitProgressMapper.toDTO(progress));
    }
}
