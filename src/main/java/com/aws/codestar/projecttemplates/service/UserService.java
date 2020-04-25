package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.User;
import com.aws.codestar.projecttemplates.repositories.StudentRepository;
import com.aws.codestar.projecttemplates.repositories.UserRepository;
import com.aws.codestar.projecttemplates.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends HibernateHelper<User> {

    UserRepository userRepository;
    UserTypeRepository userTypeRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    User findByUserName(String username) {
        Optional<User> user = userRepository.findUserByLogin(username);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return user.get();
    }
}
