package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Major;
import com.aws.codestar.projecttemplates.repositories.MajorRepository;
import com.aws.codestar.projecttemplates.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class MajorController extends HibernateObjectController<Major> {

    @Autowired
    private MajorRepository majorRepository;
    
    @Autowired
    private MajorService majorService;

    @PostConstruct
    public void init() {
        init(majorService, majorRepository);
    }
}
