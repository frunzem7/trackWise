package com.example.trackWise.repository;

import com.example.trackWise.model.AIRecommendation;
import com.example.trackWise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIRecommendationRepository extends JpaRepository<AIRecommendation, Long> {
    List<AIRecommendation> findByUser(User user);
}
