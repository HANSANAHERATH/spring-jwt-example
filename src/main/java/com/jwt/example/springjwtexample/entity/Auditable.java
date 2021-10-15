package com.jwt.example.springjwtexample.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    @CreatedBy
    @Column(columnDefinition = "bigint default 1", updatable = false)
    protected Long createdBy;

    @CreatedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'", updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @Column(columnDefinition = "bigint default 1")
    protected Long lastModifiedBy;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default '2020-04-10 20:47:05.967394'")
    protected LocalDateTime lastModifiedDate;

}
