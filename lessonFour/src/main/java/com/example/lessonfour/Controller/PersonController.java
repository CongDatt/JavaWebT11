package com.example.lessonfour.Controller;

import com.example.lessonfour.Entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/create")
    public String create() {
        return "person/create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("age") int age, @RequestParam("name") String name, Model model) {
        Person p = new Person();
        p.setAge(age);
        p.setName(name);

        model.addAttribute("person" , p);
        return "person/detail";
    }
}
