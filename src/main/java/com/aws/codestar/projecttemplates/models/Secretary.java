package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "secretary")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Secretary implements HibernateObject {

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Id
    private User user;

    @JoinColumn(name = "faculty")
    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;

    public Secretary() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public long getId() {
        return getUser().getId();
    }

    @Override
    public void setId(long id) {
        getUser().setId(id);
    }
}
