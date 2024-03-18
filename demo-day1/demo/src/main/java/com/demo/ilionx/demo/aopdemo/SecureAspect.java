package com.demo.ilionx.demo.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class SecureAspect {

    @Before("@annotation(SecurityCheck)")
    public Object checkSecurity(JoinPoint joinPoint) throws Throwable {
        System.out.println("Checking " + joinPoint.getSignature().getName());
        return joinPoint;
    }
}
