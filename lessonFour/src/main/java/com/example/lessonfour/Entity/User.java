package com.example.lessonfour.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    private String avatar;

    @Column(unique = true)
    private String username;
    private String password;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthdate;

    @Transient // this filed is not a persistence
    private MultipartFile file;

    @CreatedDate // auto gen
    private Date createdAt;
}
