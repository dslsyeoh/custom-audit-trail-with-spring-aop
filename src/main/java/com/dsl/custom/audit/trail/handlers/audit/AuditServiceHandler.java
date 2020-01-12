/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.custom.audit.trail.handlers.audit;

import com.dsl.custom.audit.trail.constant.AuditAction;
import com.dsl.custom.audit.trail.domain.AuditEntity;
import com.dsl.custom.audit.trail.repository.AuditRepository;
import com.dsl.custom.audit.trail.services.audit.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceHandler implements AuditService
{
    @Autowired
    private AuditRepository auditRepository;

    @Override
    public void create(String auditTarget)
    {
        System.out.println("create method invoked by spring aop through reflection");
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setAction(AuditAction.CREATE);
        auditEntity.setDescription(AuditAction.CREATE.name());
        auditEntity.setAuditTarget(auditTarget);
        auditRepository.save(auditEntity);
    }
}
