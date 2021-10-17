package com.jwt.example.springjwtexample.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    @CreatedBy
    @Column(updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @Column
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'")
    protected LocalDateTime lastModifiedDate;

    @PrePersist
    protected void onCreate() {
        String currentPrincipalName = null;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            currentPrincipalName = authentication.getName();
        } catch (Exception e) {
        }
        createdDate = LocalDateTime.now(ZoneId.systemDefault());
        createdBy = currentPrincipalName;
    }

    @PreUpdate
    protected void onUpdate() {
        String currentPrincipalName = null;
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            currentPrincipalName = authentication.getName();
        } catch (Exception e) {
        }
        lastModifiedDate = LocalDateTime.now(ZoneId.systemDefault());
        lastModifiedBy = currentPrincipalName;
    }

}
