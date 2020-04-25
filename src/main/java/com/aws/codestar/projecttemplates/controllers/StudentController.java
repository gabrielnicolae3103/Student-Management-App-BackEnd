package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Student;
import com.aws.codestar.projecttemplates.repositories.StudentRepository;
import com.aws.codestar.projecttemplates.repositories.UserRepository;
import com.aws.codestar.projecttemplates.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/students")
public class StudentController extends HibernateObjectController<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        init(studentService, studentRepository);
    }

    @Override
    @PutMapping(value = "/{id}")
    ResponseEntity<Student> update(@PathVariable(value = "id") long id,
                                   @RequestBody Student student) {
        Student updatedStudent = studentService.update(id, student);

        if(!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        if(updatedStudent == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(updatedStudent);
    }

}
