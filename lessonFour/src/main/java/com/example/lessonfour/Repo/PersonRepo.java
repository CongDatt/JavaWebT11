package com.example.lessonfour.Repo;

import com.example.lessonfour.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    @Query("SELECT p from Person p where p.age >= :min AND p.age <= :max ")
    List<Person> search(@Param("min") int min, @Param("max") int max);

}
