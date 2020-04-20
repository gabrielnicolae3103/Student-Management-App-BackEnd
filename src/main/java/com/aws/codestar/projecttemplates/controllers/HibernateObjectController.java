package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.HibernateObject;
import com.aws.codestar.projecttemplates.service.HibernateHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HibernateObjectController<T> {

    HibernateHelper<JpaRepository<T, Long>> service;
    JpaRepository<T, Long> repository;
    
    public void init(JpaRepository<T, Long> repository) {
        this.repository = repository;
        this.service = new HibernateHelper<>(repository);
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
        return ResponseEntity.ok(hibernateObject);
    }

    @PostMapping
    ResponseEntity<T> saveNewHibernateObject(@RequestBody T hibernateObject) {
        T response = (T) service.saveToRepository((HibernateObject) hibernateObject);
        if(response == null)
            return ResponseEntity.badRequest().body(hibernateObject);
        return ResponseEntity.ok(response);
    }
}
