package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Grupa;
import com.aws.codestar.projecttemplates.repositories.GrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/grupe")
public class GrupaController extends HibernateObjectController<Grupa> {
    @Autowired
    GrupaRepository grupaRepository;

    @PostConstruct
    public void init(){
        this.init(grupaRepository);
    }
}
