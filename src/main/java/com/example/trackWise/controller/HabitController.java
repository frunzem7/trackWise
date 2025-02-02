package com.example.trackWise.controller;

import com.example.trackWise.dto.HabitDTO;
import com.example.trackWise.mapper.HabitMapper;
import com.example.trackWise.model.Habit;
import com.example.trackWise.model.User;
import com.example.trackWise.service.HabitService;
import com.example.trackWise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/habits")
@RequiredArgsConstructor
public class HabitController {
    private final HabitService habitService;
    private final UserService userService;
    private final HabitMapper habitMapper;

    @GetMapping("/{email}")
    public ResponseEntity<List<HabitDTO>> getUserHabits(@PathVariable String email) {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        List<HabitDTO> habits = habitService.getUserHabits(user).stream()
                .map(habitMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(habits);
    }

    @PostMapping("/{email}")
    public ResponseEntity<HabitDTO> createHabit(@PathVariable String email, @RequestBody HabitDTO habitDTO) {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        Habit habit = habitMapper.toEntity(habitDTO, user);
        return ResponseEntity.ok(habitMapper.toDTO(habitService.saveHabit(habit)));
    }

    @DeleteMapping("/{habitId}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long habitId) {
        habitService.deleteHabit(habitId);
        return ResponseEntity.noContent().build();
    }
}