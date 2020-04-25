package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.User;
import com.aws.codestar.projecttemplates.repositories.UserRepository;
import com.aws.codestar.projecttemplates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController extends HibernateObjectController<User> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostConstruct
    public void init(){
        this.init(userService, userRepository);
    }

    @GetMapping("/login/{login}")
    ResponseEntity<User> findUserByLogin(@PathVariable(value = "login") String login) {
        Optional<User> user = userRepository.findUserByLogin(login);
        if(!user.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }
}
