package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Seria;
import com.aws.codestar.projecttemplates.repositories.SeriaRepository;
import com.aws.codestar.projecttemplates.service.SeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class SeriaController extends HibernateObjectController<Seria> {

    @Autowired
    private SeriaRepository seriaRepository;

    @Autowired
    private SeriaService seriaService;

    @PostConstruct
    public void init() {
        init(seriaService, seriaRepository);
    }
}
