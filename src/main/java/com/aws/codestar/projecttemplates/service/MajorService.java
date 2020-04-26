package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.Major;
import com.aws.codestar.projecttemplates.repositories.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService extends HibernateHelper<Major> {

    private MajorRepository majorRepository;

    @Autowired
    public MajorService(MajorRepository majorRepository) {
        super(majorRepository);
    }
}
