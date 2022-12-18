package com.example.lessonfour.Repo;

import com.example.lessonfour.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
