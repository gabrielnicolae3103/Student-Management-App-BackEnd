package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    @NotNull
    private String type;


    @JsonIgnore
    @OneToOne(mappedBy = "userType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    public UserType() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
