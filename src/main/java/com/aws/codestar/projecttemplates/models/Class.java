package com.aws.codestar.projecttemplates.models;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
