package com.example.trackWise.controller;

import com.example.trackWise.dto.AIRecommendationDTO;
import com.example.trackWise.mapper.AIRecommendationMapper;
import com.example.trackWise.model.User;
import com.example.trackWise.service.AIRecommendationService;
import com.example.trackWise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AIRecommendationController {
    private final AIRecommendationService aiRecommendationService;
    private final UserService userService;
    private final AIRecommendationMapper aiRecommendationMapper;

    @GetMapping("/{email}")
    public ResponseEntity<List<AIRecommendationDTO>> getUserRecommendations(@PathVariable String email) {
        User user = userService.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        List<AIRecommendationDTO> recommendations = aiRecommendationService.getUserRecommendations(user).stream()
                .map(aiRecommendationMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(recommendations);
    }
}