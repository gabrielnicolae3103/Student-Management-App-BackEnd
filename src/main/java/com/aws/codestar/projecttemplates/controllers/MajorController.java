package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Major;
import com.aws.codestar.projecttemplates.repositories.MajorRepository;
import com.aws.codestar.projecttemplates.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/majors")
public class MajorController extends HibernateObjectController<Major> {

    @Autowired
    private MajorRepository majorRepository;

    @Autowired
    private MajorService majorService;

    @PostConstruct
    public void init() {
        this.init(majorService, majorRepository);
    }
}
