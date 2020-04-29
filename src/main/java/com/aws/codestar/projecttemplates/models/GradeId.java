package com.aws.codestar.projecttemplates.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradeId implements Serializable {

    @Column(name = "student_identification_number")
    Long sin;

    @Column(name = "class_id")
    Long classId;

    public GradeId() {
    }

    public GradeId(Long sin, Long classId) {
        this.sin = sin;
        this.classId = classId;
    }

    public Long getSin() {
        return sin;
    }

    public void setSin(Long sin) {
        this.sin = sin;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeId gradeId = (GradeId) o;
        return sin.equals(gradeId.sin) &&
                classId.equals(gradeId.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sin, classId);
    }
}
