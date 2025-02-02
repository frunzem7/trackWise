package com.example.trackWise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HabitDTO {
    private Long id;
    private Long userId; // Instead of User entity
    private String name;
    private String description;
    private int targetFrequency;
}