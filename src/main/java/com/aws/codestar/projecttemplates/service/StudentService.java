package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Student;
import com.aws.codestar.projecttemplates.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends HibernateHelper<Student> {

    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        super(studentRepository);
    }

    @Override
    public Student findById(long id) {
        if(!studentRepository.existsStudentByUserId(id))
            return null;
        return studentRepository.findStudentByUserId(id);
    }
}
