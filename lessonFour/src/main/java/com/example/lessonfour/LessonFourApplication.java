package com.example.lessonfour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LessonFourApplication {

    public static void main(String[] args) {
        SpringApplication.run(LessonFourApplication.class, args);
    }

}
