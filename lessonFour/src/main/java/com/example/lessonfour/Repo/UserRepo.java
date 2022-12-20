package com.example.lessonfour.Repo;

import com.example.lessonfour.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
