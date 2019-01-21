package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() { }
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() { }
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() { }
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() { }
	
	@Before("forAppFlow()")
	private void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("    ====> in @Before: calling method " + method);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			myLogger.info("        ====> argument: " + arg);
		}
	}
	
	@AfterReturning(
		pointcut="forAppFlow()",
		returning="result"
	)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("    ====> in @AfterReturning: from method " + method);
		myLogger.info("    ====> in @AfterReturning: result: " + result);
	}
}
