package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {
		System.out.println("Execution of @Before advice EVERYWHERE inside this package!!!");
	}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("Execution of @Before advice");
	}
	
	@Before("forDAOPackage()")
	public void performAPIAnalytics() {
		System.out.println("API Analytics performed!!!");
	}

}
