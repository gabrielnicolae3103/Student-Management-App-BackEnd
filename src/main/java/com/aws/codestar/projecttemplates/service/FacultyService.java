package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Faculty;
import com.aws.codestar.projecttemplates.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService extends HibernateHelper<Faculty> {
    @Autowired
    FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        super(facultyRepository);
    }

}
