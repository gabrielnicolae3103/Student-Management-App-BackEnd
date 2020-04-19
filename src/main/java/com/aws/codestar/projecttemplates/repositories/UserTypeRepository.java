package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    Optional<UserType> findByType(String type);
    List<UserType> findAll();
}
