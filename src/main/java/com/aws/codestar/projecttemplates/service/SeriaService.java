package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Seria;
import com.aws.codestar.projecttemplates.repositories.SeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriaService extends HibernateHelper<Seria> {

    @Autowired
    private SeriaRepository seriaRepository;

    public SeriaService(SeriaRepository seriaRepository) {
        super(seriaRepository);
    }
}
