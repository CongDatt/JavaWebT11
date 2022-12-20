package com.example.lessonfour.Controller;

import com.example.lessonfour.Entity.User;
import com.example.lessonfour.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/new")
    public String add() {
        return "user/add";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute User user) throws IllegalStateException, IOException {
        System.out.println(user);
        if(user.getFile() != null && !user.getFile().isEmpty()) {
            final String UPLOAD_FOLDER = "D:/file/";

            String fileName = user.getFile().getOriginalFilename();
            File newFile = new File(UPLOAD_FOLDER + fileName);
            user.getFile().transferTo(newFile);
            user.setAvatar(UPLOAD_FOLDER + fileName);
        }
        userRepo.save(user);
        return "redirect:/user/search";
    }
}
