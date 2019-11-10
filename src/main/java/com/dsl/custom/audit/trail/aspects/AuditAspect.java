/*
 * Author Steven Yeoh
 * Copyright (c) 2019. All rights reserved
 */

package com.dsl.custom.audit.trail.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect
{
    @Autowired
    private ApplicationContext applicationContext;

    @AfterReturning(value = "@annotation(audited)", returning = "retVal")
    public void auditAfterStockServiceInvoked(Object retVal, Audited audited) throws Throwable
    {
        System.out.println("audit after stock service invoked");
        System.out.println("retVal: " + retVal);
        System.out.println("audited annotation value: " + audited.value());

        Class<?> clazz = audited.target();
        Object object = applicationContext.getBean(clazz);
        clazz.getMethod("create", String.class).invoke(object, audited.value());
    }
}
