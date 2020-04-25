package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Faculty;
import com.aws.codestar.projecttemplates.models.HibernateObject;
import com.aws.codestar.projecttemplates.repositories.FacultyRepository;
import com.aws.codestar.projecttemplates.repositories.GrupaRepository;
import com.aws.codestar.projecttemplates.service.FacultyService;
import com.aws.codestar.projecttemplates.service.HibernateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController extends  HibernateObjectController<Faculty> {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    FacultyService facultyService;

    @PostConstruct
    public void init(){
        this.init(facultyService, facultyRepository);
    }


}
