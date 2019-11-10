/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.custom.audit.trail.constant;

import lombok.Getter;

@Getter
public enum AuditAction
{
    CREATE("CREATED NEW RECORD"),
    EDIT("EDITED RECORD"),
    DELETE("DELETED RECORD");

    private String action;

    AuditAction(String action)
    {
        this.action = action;
    }


}
