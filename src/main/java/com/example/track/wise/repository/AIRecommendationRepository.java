package com.example.track.wise.repository;

import com.example.track.wise.model.AIRecommendation;
import com.example.track.wise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIRecommendationRepository extends JpaRepository<AIRecommendation, Long> {
    List<AIRecommendation> findByUser(User user);
}
