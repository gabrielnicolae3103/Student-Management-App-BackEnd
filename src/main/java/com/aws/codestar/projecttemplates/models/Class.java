package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Class implements HibernateObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "credit_points")
    @NotNull
    private int creditPoints;

    @Column(name = "type")
    @NotNull
    private char type;

    @Column(name = "year")
    @NotNull
    private int year;

    @Column(name = "semester")
    @NotNull
    private int semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Major major;

    @OneToMany(mappedBy = "aClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Grade> grades = new ArrayList<>();

    public Class() {
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
