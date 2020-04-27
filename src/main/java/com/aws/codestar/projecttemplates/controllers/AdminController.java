package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Admin;
import com.aws.codestar.projecttemplates.repositories.AdminRepository;
import com.aws.codestar.projecttemplates.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admins")
public class AdminController extends HibernateObjectController<Admin> {

    AdminRepository adminRepository;
    AdminService adminService;

    @Autowired
    public AdminController(AdminRepository adminRepository, AdminService adminService) {
        init(adminService, adminRepository);
    }

    @Override
    @PutMapping(value = "/{id}")
    ResponseEntity<Admin> update(@PathVariable(value = "id") long id,
                                   @RequestBody Admin admin) {
        Admin adminUpdated = adminService.update(id, admin);

        if(!adminRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(adminUpdated == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(adminUpdated);
    }

    @GetMapping(value = "/username/{username}")
    ResponseEntity<Admin> getByUsername(@PathVariable(value = "username") String username) {
        if(!adminRepository.existsAdminByUserLogin(username))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(adminRepository.findAdminByUserLogin(username));
    }
}
