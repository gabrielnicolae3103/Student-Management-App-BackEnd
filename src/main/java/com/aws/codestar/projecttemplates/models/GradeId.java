package com.aws.codestar.projecttemplates.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradeId implements Serializable {

    @Column(name = "student_identification_number")
    private long sin;

    @Column(name = "class_id")
    private long classId;

    public GradeId() {
    }

    public GradeId(long sin, long classId) {
        this.sin = sin;
        this.classId = classId;
    }

    public long getSin() {
        return sin;
    }

    public void setSin(long sin) {
        this.sin = sin;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeId gradeId = (GradeId) o;
        return sin == gradeId.sin &&
                classId == gradeId.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sin, classId);
    }
}
