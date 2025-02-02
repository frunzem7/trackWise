package com.example.trackWise.mapper;

import com.example.trackWise.dto.HabitDTO;
import com.example.trackWise.model.Habit;
import com.example.trackWise.model.User;
import org.springframework.stereotype.Component;

@Component
public class HabitMapper {
    public HabitDTO toDTO(Habit habit) {
        HabitDTO dto = new HabitDTO();
        dto.setId(habit.getId());
        dto.setUserId(habit.getUser().getId());
        dto.setName(habit.getName());
        dto.setDescription(habit.getDescription());
        dto.setTargetFrequency(habit.getTargetFrequency());
        return dto;
    }

    public Habit toEntity(HabitDTO habitDTO, User user) {
        Habit habit = new Habit();
        habit.setUser(user);
        habit.setName(habitDTO.getName());
        habit.setDescription(habitDTO.getDescription());
        habit.setTargetFrequency(habitDTO.getTargetFrequency());
        return habit;
    }
}