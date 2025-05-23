package com.example.track.wise.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class AIRecommendationDTO {
    private Long id;
    private String insight;
    private LocalDateTime generatedAt;
}