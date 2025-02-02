package com.example.trackWise.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class HabitProgressDTO {
    private Long id;
    private Long habitId; // Instead of Habit entity
    private LocalDate date;
    private boolean completed;
}