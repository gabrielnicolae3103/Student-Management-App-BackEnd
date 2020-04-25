package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Grupa;
import com.aws.codestar.projecttemplates.repositories.GrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupaService extends HibernateHelper<Grupa> {

    @Autowired
    GrupaRepository grupaRepository;

    public GrupaService(GrupaRepository grupaRepository) {
        super(grupaRepository);
    }
}
