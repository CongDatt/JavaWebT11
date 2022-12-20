package com.example.lessonfour.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    private String role; // Admin, member
}
