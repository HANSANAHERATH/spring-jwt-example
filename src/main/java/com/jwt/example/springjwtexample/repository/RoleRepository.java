package com.jwt.example.springjwtexample.repository;

import com.jwt.example.springjwtexample.entity.Role;
import com.jwt.example.springjwtexample.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}