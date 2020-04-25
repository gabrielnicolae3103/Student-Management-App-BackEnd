package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Student;
import com.aws.codestar.projecttemplates.repositories.StudentRepository;
import com.aws.codestar.projecttemplates.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class StudentController extends HibernateObjectController<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init() {
        init(studentService, studentRepository);
    }

}
