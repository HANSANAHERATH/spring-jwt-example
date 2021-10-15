package com.jwt.example.springjwtexample.entity;

import com.jwt.example.springjwtexample.enums.ERole;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "roles", schema = "security")
public class Role implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role(){}
}
