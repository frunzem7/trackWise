package com.example.trackWise.mapper;


import com.example.trackWise.dto.HabitProgressDTO;
import com.example.trackWise.model.HabitProgress;
import org.springframework.stereotype.Component;

@Component
public class HabitProgressMapper {
    public HabitProgressDTO toDTO(HabitProgress habitProgress) {
        HabitProgressDTO dto = new HabitProgressDTO();
        dto.setId(habitProgress.getId());
        dto.setHabitId(habitProgress.getHabit().getId());
        dto.setDate(habitProgress.getDate());
        dto.setCompleted(habitProgress.isCompleted());
        return dto;
    }
}