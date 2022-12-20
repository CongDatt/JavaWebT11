package com.example.lessonfour.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {
    @Id
    public int id;

    @Column(unique = true)
    private String studentCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
}
