package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "admin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin implements HibernateObject, Serializable {

    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private User user;

    public Admin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
