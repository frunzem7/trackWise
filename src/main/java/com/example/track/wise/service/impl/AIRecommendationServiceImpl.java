package com.example.track.wise.service.impl;

import com.example.track.wise.model.AIRecommendation;
import com.example.track.wise.model.User;
import com.example.track.wise.repository.AIRecommendationRepository;
import com.example.track.wise.service.AIRecommendationService;
import com.example.track.wise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIRecommendationServiceImpl implements AIRecommendationService {
    private final AIRecommendationRepository aiRecommendationRepository;
    private final OpenAiChatClient chatClient;
    private final UserService userService;

    @Override
    public String ask(String question, String userEmail) {
        User user = userService.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ChatResponse response = chatClient.call(new Prompt(question));
        String insight = response.getResult().getOutput().getContent();

        saveRecommendation(user, insight);

        return insight;
    }

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