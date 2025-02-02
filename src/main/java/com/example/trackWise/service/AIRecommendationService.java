package com.example.trackWise.service;

import com.example.trackWise.model.AIRecommendation;
import com.example.trackWise.model.User;

import java.util.List;

public interface AIRecommendationService {
    List<AIRecommendation> getUserRecommendations(User user);
    AIRecommendation saveRecommendation(User user, String insight);
}
