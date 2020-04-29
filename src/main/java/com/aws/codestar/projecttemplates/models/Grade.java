package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

    @EmbeddedId
    @JsonIgnore
    private GradeId gradeId = new GradeId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classId")
    @JoinColumn(name = "class_id")
    private Class clasa;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sin")
    @JoinColumn(name = "student_identification_number")
    private Student student;

    @Column(name = "grade")
    private Integer grade;

    public Grade() {
    }

    public Grade(GradeId gradeId, Class clasa, Student student, int grade) {
        this.gradeId = gradeId;
        this.clasa = clasa;
        this.student = student;
        this.grade = grade;
    }

    public GradeId getGradeId() {
        return gradeId;
    }

    public void setGradeId(GradeId gradeId) {
        this.gradeId = gradeId;
    }

    public Class getClasa() {
        return clasa;
    }

    public void setClasa(Class clasa) {
        this.clasa = clasa;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
