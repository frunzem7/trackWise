package com.example.track.wise.mapper;


import com.example.track.wise.model.HabitProgress;
import com.example.track.wise.dto.HabitProgressDTO;
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