/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved
 */

package com.dsl.custom.audit.trail.services.audit;

public interface AuditService
{
    void create(String auditTarget);
}
