package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void runEverywhere() {
		System.out.println("Execution of @Before advice EVERYWHERE inside this package!!!");
	}

	@Before("execution(public * com.luv2code.aopdemo.dao.AccountDAO.add*(com.luv2code.aopdemo.Account))")
	public void beforeAddAccountAdvice() {
		System.out.println("Execution of @Before advice");
	}

}
