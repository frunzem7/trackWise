package com.example.trackWise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.trackWise.repository") // Enables JPA Repositories
public class TrackWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackWiseApplication.class, args);
    }

}
