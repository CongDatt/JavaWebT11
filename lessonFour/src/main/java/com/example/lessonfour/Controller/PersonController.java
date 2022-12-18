package com.example.lessonfour.Controller;

import com.example.lessonfour.Entity.Person;
import com.example.lessonfour.Repo.PersonRepo;
import com.example.lessonfour.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    PersonService personService;

    @GetMapping("/create")
    public String create() {
        return "person/create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("age") int age, @RequestParam("name") String name, Model model) {
        Person p = new Person();
        p.setAge(age);
        p.setName(name);
        personRepo.save(p);

        model.addAttribute("person" , p);
        return "redirect:/person/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Person> list = personService.getAllPerson();
        model.addAttribute("list", list);
        return "person/list";
    }
}
