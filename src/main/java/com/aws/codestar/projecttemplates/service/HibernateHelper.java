package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.models.HibernateObject;
import org.springframework.data.jpa.repository.JpaRepository;

public class HibernateHelper<T> {


    private JpaRepository<HibernateObject, Long> repository;

    public HibernateHelper(T repository) {
        this.repository = (JpaRepository<HibernateObject, Long>)repository;
    }

    public HibernateObject findById(long id) {
        return repository.findById(id).orElse(null);
    }

    public HibernateObject saveToRepository(HibernateObject object) {
        HibernateObject objectToFind = findById(object.getId());
        System.out.println(object.getId());
        System.out.println(objectToFind);
        /* daca exista deja */
        if(objectToFind != null)
            return null;
        HibernateObject saved = repository.save(object);
        saved.setId(object.getId());
        repository.flush();
        System.out.println(saved.getId());
        return saved;
    }
}
