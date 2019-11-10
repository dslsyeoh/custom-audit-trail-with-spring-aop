/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.custom.audit.trail.domain;

import com.dsl.custom.audit.trail.constant.AuditAction;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;

import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "audit")
public class AuditEntity
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    public Long id;

    @Column(updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private AuditAction action;

    @Column(updatable = false, nullable = false)
    private String auditTarget;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createdTimestamp;
}
