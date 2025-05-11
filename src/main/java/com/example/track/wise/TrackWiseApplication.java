package com.example.track.wise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.track.wise.repository")
@EntityScan("com.example.track.wise.model")
public class TrackWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackWiseApplication.class, args);
    }

}
