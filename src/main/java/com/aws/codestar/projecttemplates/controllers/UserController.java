package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.User;
import com.aws.codestar.projecttemplates.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController extends HibernateObjectController<User> {
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

    @GetMapping("/login/{login}")
    ResponseEntity<User> findUserByLogin(@PathVariable(value = "login") String login) {
        Optional<User> user = userRepository.findUserByLogin(login);
        if(!user.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }
}
