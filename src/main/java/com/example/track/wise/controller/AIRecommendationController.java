package com.example.track.wise.controller;

import com.example.track.wise.dto.AIRecommendationDTO;
import com.example.track.wise.mapper.AIRecommendationMapper;
import com.example.track.wise.model.User;
import com.example.track.wise.service.AIRecommendationService;
import com.example.track.wise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AIRecommendationController {
    private final AIRecommendationService aiRecommendationService;
    private final UserService userService;
    private final AIRecommendationMapper aiRecommendationMapper;

    @GetMapping("/ask")
    public String ask(@RequestParam String question, @RequestParam String email) {
        return aiRecommendationService.ask(question, email);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<AIRecommendationDTO>> getUserRecommendations(@PathVariable String email) {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        List<AIRecommendationDTO> recommendations = aiRecommendationService.getUserRecommendations(user).stream()
                .map(aiRecommendationMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(recommendations);
    }
}