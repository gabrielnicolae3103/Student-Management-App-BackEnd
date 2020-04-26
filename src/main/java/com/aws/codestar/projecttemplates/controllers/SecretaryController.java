package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Secretary;
import com.aws.codestar.projecttemplates.repositories.SecretaryRepository;
import com.aws.codestar.projecttemplates.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(value = "/secretaries")
public class SecretaryController extends HibernateObjectController<Secretary> {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private SecretaryService secretaryService;

    @PostConstruct
    public void init() {
        init(secretaryService, secretaryRepository);
    }
}
