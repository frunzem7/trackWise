package com.example.track.wise.controller;

import com.example.track.wise.mapper.HabitProgressMapper;
import com.example.track.wise.model.Habit;
import com.example.track.wise.model.HabitProgress;
import com.example.track.wise.service.HabitService;
import com.example.track.wise.dto.HabitProgressDTO;
import com.example.track.wise.service.HabitProgressService;
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
