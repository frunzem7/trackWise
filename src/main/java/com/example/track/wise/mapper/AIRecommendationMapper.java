package com.example.track.wise.mapper;

import com.example.track.wise.dto.AIRecommendationDTO;
import com.example.track.wise.model.AIRecommendation;
import org.springframework.stereotype.Component;

@Component
public class AIRecommendationMapper {
    public AIRecommendationDTO toDTO(AIRecommendation aiRecommendation) {
        AIRecommendationDTO dto = new AIRecommendationDTO();
        dto.setId(aiRecommendation.getId());
        dto.setInsight(aiRecommendation.getInsight());
        dto.setGeneratedAt(aiRecommendation.getGeneratedAt());
        return dto;
    }
}