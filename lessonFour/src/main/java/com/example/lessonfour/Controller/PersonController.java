package com.example.lessonfour.Controller;

import com.example.lessonfour.Entity.Person;
import com.example.lessonfour.Repo.PersonRepo;
import com.example.lessonfour.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public String search() {
        return "person/search";
    }
    @PostMapping("/search")
    public String search(@RequestParam("max") int max, @RequestParam("min") int min, Model model) {
        List<Person> list = personRepo.search(min, max  );
        model.addAttribute("list", list);
        return "person/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Person person = personRepo.findById(id).orElse(null);
        model.addAttribute("person", person);
        return "person/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        personRepo.deleteById(id);
        return "redirect:/person/list";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute Person person) {
        personRepo.save(person);
        return "redirect:/person/list";
    }
}
