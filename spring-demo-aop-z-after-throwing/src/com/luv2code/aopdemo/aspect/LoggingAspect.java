package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AspectPointcuts.allMethodsExceptGettersAndSetters()")
	public void logWhenNewAccountIsAdded(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("method being executed: " + methodSignature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			if (arg instanceof Account) {
				System.out.println((Account) arg);
			}
		}
		
		System.out.println("New acount logged");
	}
	
	@AfterReturning(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		returning="result"
	)
	public void afterReturnFindAccount(JoinPoint joinPoint, List<Account> result) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("after returning: method signature: " + signature);
		System.out.println("result is: " + result);
		
		convertAccountNamesToUpperCase(result);
	}
	
	@AfterThrowing(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		throwing="e"
	)
	public void afterThrowingExample(JoinPoint joinPoint, Throwable e) {
		System.out.println("@AfterThrowing: " + e);
	}

	private void convertAccountNamesToUpperCase(List<Account> accounts) {
		for (Account account : accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}

}
