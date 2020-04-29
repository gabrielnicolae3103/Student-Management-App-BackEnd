package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Class;
import com.aws.codestar.projecttemplates.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService extends HibernateHelper<Class> {

    ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        super(classRepository);
        this.classRepository = classRepository;
    }
}
