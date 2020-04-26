package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Secretary;
import com.aws.codestar.projecttemplates.repositories.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretaryService extends HibernateHelper<Secretary> {

    private SecretaryRepository secretaryRepository;

    @Autowired
    public SecretaryService(SecretaryRepository secretaryRepository) {
        super(secretaryRepository);
    }
}
