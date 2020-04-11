package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "seria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "grupa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;

    public Seria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
