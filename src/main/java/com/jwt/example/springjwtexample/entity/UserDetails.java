package com.jwt.example.springjwtexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user_details", schema = "security")
public class UserDetails extends Auditable implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles", schema = "security",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserDetails(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserDetails(){}

}
