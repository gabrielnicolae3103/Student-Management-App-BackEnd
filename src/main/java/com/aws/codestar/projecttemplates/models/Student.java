package com.aws.codestar.projecttemplates.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements HibernateObject {

    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @NotNull
    @Column(name = "student_identification_number")
    private int sin;

    @NotNull
    @Column(name = "father_initial")
    private String father_initial;

    @NotNull
    @Column(name = "cnp")
    @Id
    private long cnp;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupa")
    private Grupa grupa;

    public Student() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSin() {
        return sin;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }

    public String getFather_initial() {
        return father_initial;
    }

    public void setFather_initial(String father_initial) {
        this.father_initial = father_initial;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    @JsonIgnore
    public long getId() {
        return getUser().getId();
    }

    @Override
    public void setId(long id) {
        getUser().setId(id);
    }
}
