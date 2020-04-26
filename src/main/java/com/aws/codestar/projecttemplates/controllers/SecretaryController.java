package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Secretary;
import com.aws.codestar.projecttemplates.repositories.SecretaryRepository;
import com.aws.codestar.projecttemplates.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/secretaries")
public class SecretaryController extends HibernateObjectController<Secretary> {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private SecretaryService secretaryService;

    @PostConstruct
    public void init() {
        init(secretaryService, secretaryRepository);
    }

    @Override
    @PutMapping(value = "/{id}")
    ResponseEntity<Secretary> update(@PathVariable(value = "id") long id,
                                     @RequestBody Secretary secretary) {
        Secretary updatedSecretary = secretaryService.update(id, secretary);

        if(!secretaryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(updatedSecretary == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updatedSecretary);
    }

    @GetMapping(value = "/username/{username}")
    ResponseEntity<Secretary> getByUsername(@PathVariable(value = "username") String username) {
        if(!secretaryRepository.existsSecretaryByUserLogin(username))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(secretaryRepository.findSecretaryByUserLogin(username));
    }
}
