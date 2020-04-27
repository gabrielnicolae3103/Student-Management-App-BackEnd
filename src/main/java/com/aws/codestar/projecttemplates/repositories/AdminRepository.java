package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Boolean existsAdminByUserLogin(String login);
    Admin findAdminByUserLogin(String login);
}
