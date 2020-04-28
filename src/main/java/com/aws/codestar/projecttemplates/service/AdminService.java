package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Admin;
import com.aws.codestar.projecttemplates.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends HibernateHelper<Admin> {

    @Autowired
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        super(adminRepository);
    }

    @Override
    public Admin findById(long id) {
        if(!adminRepository.existsAdminByUserId(id))
            return null;
        return adminRepository.findAdminByUserId(id);
    }
}
