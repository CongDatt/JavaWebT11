package com.example.lessonfour.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    private double score;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
}
