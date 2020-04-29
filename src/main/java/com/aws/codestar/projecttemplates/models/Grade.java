package com.aws.codestar.projecttemplates.models;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {

    @EmbeddedId
    private GradeId gradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classId")
    private Class aClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sin")
    private Student student;

    @Column(name = "grade")
    private int grade;

    public Grade() {
    }

    public GradeId getGradeId() {
        return gradeId;
    }

    public void setGradeId(GradeId gradeId) {
        this.gradeId = gradeId;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
