package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Admin;
import com.aws.codestar.projecttemplates.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends HibernateHelper<Admin> {

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        super(adminRepository);
    }
}
