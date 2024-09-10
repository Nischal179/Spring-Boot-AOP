package com.nischal.aopdemo.aop;

import com.nischal.aopdemo.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class EmployeeAspect {

    @Pointcut("execution(* com.nischal.aopdemo.controller.EmployeeController.*(..))")
    private void forEmployeeController() {}

    @Pointcut("execution(* com.nischal.aopdemo.service.EmployeeService.*(..))")
    private void forEmployeeService() {}


// In this method I am displaying called method's signature
    @Before(value = "forEmployeeController()")
    public void beforeAdvice(JoinPoint joinPoint) {

        // Method signature
        System.out.println("Method: " + (MethodSignature)joinPoint.getSignature());

        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }

    @After(value = "forEmployeeController()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
    }

    // Method for logging any methods of EmployeeService class
    // as well as display the arguments of the called method
    @Before(value = "forEmployeeService()")
    public void beforeAdviceForService(JoinPoint joinPoint) {

        // Display method arguments

        // get arguments
        Object[] args = joinPoint.getArgs();

        // loop through arguments
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Employee) {

                // downcast and print Employee specific stuff
                Employee theEmployee = (Employee) tempArg;

                System.out.println("Employee name: " + theEmployee.getName());
                System.out.println("Employee id: " + theEmployee.getId());
            }
        }

        System.out.println("Request to service layer " + joinPoint.getSignature() + " started at " + new Date());
    }

    @After(value = "forEmployeeService()")
    public void afterAdviceForService(JoinPoint joinPoint) {
        System.out.println("Request to service layer " + joinPoint.getSignature() + " ended at " + new Date());
    }
}
