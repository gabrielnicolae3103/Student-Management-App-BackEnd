package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Faculty;
import com.aws.codestar.projecttemplates.models.HibernateObject;
import com.aws.codestar.projecttemplates.service.HibernateHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class HibernateObjectController<T extends HibernateObject> {

    HibernateHelper<T> service;
    JpaRepository<T, Long> repository;

    public void init(HibernateHelper<T> service,
                     JpaRepository<T, Long> repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    List<T> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<T> findById(@PathVariable(value = "id") int id) {
        T hibernateObject = (T) service.findById(id);
        if(hibernateObject == null)
            return ResponseEntity.notFound().build();
        return ok(hibernateObject);
    }

    @PostMapping
    ResponseEntity<T> saveNewHibernateObject(@RequestBody T hibernateObject) {
        T response = service.saveToRepository(hibernateObject);
        if(response == null)
            return ResponseEntity.badRequest().body(hibernateObject);
        return ok(response);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<T> updateFaculty(@PathVariable(value = "id") long id,
                                    @RequestBody T object) {
        T updatedObject = service.update(id, object);

        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(updatedObject == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updatedObject);
    }
}
