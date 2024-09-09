package com.nischal.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class EmployeeAspect {

    @Pointcut("execution(* com.nischal.aopdemo.controller.EmployeeController.*(..))")
    private void forEmployeeController() {}

    @Pointcut("execution(* com.nischal.aopdemo.service.EmployeeService.*(..))")
    private void forEmployeeService() {}

    @Before(value = "forEmployeeController()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }

    @After(value = "forEmployeeController()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
    }

    @Before(value = "forEmployeeService()")
    public void beforeAdviceForService(JoinPoint joinPoint) {
        System.out.println("Request to service layer " + joinPoint.getSignature() + " started at " + new Date());
    }

    @After(value = "forEmployeeService()")
    public void afterAdviceForService(JoinPoint joinPoint) {
        System.out.println("Request to service layer " + joinPoint.getSignature() + " ended at " + new Date());
    }
}
