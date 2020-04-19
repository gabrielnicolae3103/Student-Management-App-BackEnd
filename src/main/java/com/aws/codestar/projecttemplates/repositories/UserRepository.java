package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByLogin(String login);
    List<User> findAll();
}
