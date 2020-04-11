package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Student;
import com.aws.codestar.projecttemplates.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }
}
