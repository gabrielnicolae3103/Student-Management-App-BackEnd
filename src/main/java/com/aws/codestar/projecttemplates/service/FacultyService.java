package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Faculty;
import com.aws.codestar.projecttemplates.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    public Faculty findById(long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty saveNewFaculty(Faculty faculty) {
        Faculty facultyToFind = findById(faculty.getId());

        /* daca exista deja */
        if(facultyToFind != null)
            return null;
        Faculty saved = facultyRepository.save(faculty);
        saved.setId(faculty.getId());
        return saved;
    }
}
