package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.User;
import com.aws.codestar.projecttemplates.repositories.UserRepository;
import com.aws.codestar.projecttemplates.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    UserTypeRepository userTypeRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    User findByUserName(String username) {
        Optional<User> user = userRepository.findUserByLogin(username);
        return user.orElse(null);
    }
}
