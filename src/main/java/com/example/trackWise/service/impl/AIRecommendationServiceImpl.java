package com.example.trackWise.service.impl;

import com.example.trackWise.model.AIRecommendation;
import com.example.trackWise.model.User;
import com.example.trackWise.repository.AIRecommendationRepository;
import com.example.trackWise.service.AIRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIRecommendationServiceImpl implements AIRecommendationService {
    private final AIRecommendationRepository aiRecommendationRepository;

    @Override
    public List<AIRecommendation> getUserRecommendations(User user) {
        return aiRecommendationRepository.findByUser(user);
    }

    @Override
    public AIRecommendation saveRecommendation(User user, String insight) {
        AIRecommendation recommendation = new AIRecommendation();
        recommendation.setUser(user);
        recommendation.setInsight(insight);
        recommendation.setGeneratedAt(java.time.LocalDateTime.now());
        return aiRecommendationRepository.save(recommendation);
    }
}