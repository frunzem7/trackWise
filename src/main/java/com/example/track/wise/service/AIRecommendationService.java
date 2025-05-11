package com.example.track.wise.service;

import com.example.track.wise.model.AIRecommendation;
import com.example.track.wise.model.User;

import java.util.List;

public interface AIRecommendationService {
    String ask(String question, String userId);

    List<AIRecommendation> getUserRecommendations(User user);

    AIRecommendation saveRecommendation(User user, String insight);
}
