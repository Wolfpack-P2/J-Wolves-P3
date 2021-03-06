package com.revature.controllers;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class RegisterController {


    private UserRepository userRepo;

    @Autowired
    public RegisterController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public String registerUser(@RequestBody User user) {
        if (userRepo.findByUsername(user.getUsername()) == null) {
            /*userRepo.registerUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword());*/
            userRepo.save(user);
            return "success";
        } else {
            return "duplicate username";
        }
    }

}
