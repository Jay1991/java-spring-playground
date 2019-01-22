package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Before("com.luv2code.aopdemo.aspect.AspectPointcuts.allMethodsExceptGettersAndSetters()")
	public void logWhenNewAccountIsAdded(JoinPoint joinPoint) {
		logger.info("@Before: JoinPoint" + joinPoint);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			if (arg instanceof Account) {
				logger.info("Arg: " + (Account) arg);
			}
		}
	}
	
	@AfterReturning(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		returning="result"
	)
	public void afterReturnFindAccount(JoinPoint joinPoint, List<Account> result) {
		logger.info("@AfterReturning: JoinPoint: " + joinPoint + " - Result: " + result);
		
		convertAccountNamesToUpperCase(result);
	}
	
	@AfterThrowing(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		throwing="e"
	)
	public void afterThrowingExample(JoinPoint joinPoint, Throwable e) {
		logger.info("@AfterThrowing: JoinPoint: " + joinPoint + " - Exception: " + e);
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyExample(JoinPoint joinPoint) {
		logger.info("@After: JoinPoint: " + joinPoint);
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundExample(ProceedingJoinPoint proceedingJointPoint) throws Throwable {
		String method = proceedingJointPoint.getSignature().toShortString();
		logger.info("Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		Object result = proceedingJointPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		logger.info("took " + duration + " ms to execute");
		
		return result;
	}

	private void convertAccountNamesToUpperCase(List<Account> accounts) {
		for (Account account : accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}

}
