package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "grupa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grupa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "seria")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Seria seria;

    @NotNull
    @Column(name = "number")
    private int number;

    @JsonIgnore
    @OneToOne(mappedBy = "grupa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;

    public Grupa() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seria getSeria() {
        return seria;
    }

    public void setSeria(Seria seria) {
        this.seria = seria;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
