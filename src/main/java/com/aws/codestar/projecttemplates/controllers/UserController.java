package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.User;
import com.aws.codestar.projecttemplates.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
