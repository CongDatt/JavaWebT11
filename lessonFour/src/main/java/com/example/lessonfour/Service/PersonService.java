package com.example.lessonfour.Service;

import com.example.lessonfour.Entity.Person;
import com.example.lessonfour.Repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }
}
