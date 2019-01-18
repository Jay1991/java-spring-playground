package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void allMethods() { }
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() { }
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() { }
	
	@Pointcut("allMethods() && !(getter() || setter())")
	private void allMethodsExceptGettersAndSetters() { }
	
	@Before("allMethodsExceptGettersAndSetters()")
	public void performAPIAnalytics() {
		System.out.println("\nAPI Analytics performed!!!");
	}

}
