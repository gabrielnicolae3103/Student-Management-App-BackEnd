package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Faculty;
import com.aws.codestar.projecttemplates.repositories.FacultyRepository;
import com.aws.codestar.projecttemplates.service.FacultyService;
import com.aws.codestar.projecttemplates.service.HibernateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    FacultyService facultyService;

    HibernateHelper<FacultyRepository> hibernateHelper;

    public FacultyController() {
        this.hibernateHelper = new HibernateHelper<>(facultyRepository);
    }

    @GetMapping
    List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Faculty> findById(@PathVariable(value = "id") int id) {
        Faculty faculty = (Faculty) hibernateHelper.findById(id);
        if(faculty == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    ResponseEntity<Faculty> saveNewFaculty(@RequestBody Faculty faculty) {
        Faculty response = (Faculty) hibernateHelper.saveToRepository(faculty);
        if(response == null)
            return ResponseEntity.badRequest().body(faculty);
        return ResponseEntity.ok(response);
    }
}
