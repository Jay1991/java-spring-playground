package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
		System.out.println("@Before: JoinPoint" + joinPoint);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			if (arg instanceof Account) {
				System.out.println("Arg: " + (Account) arg);
			}
		}
	}
	
	@AfterReturning(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		returning="result"
	)
	public void afterReturnFindAccount(JoinPoint joinPoint, List<Account> result) {
		System.out.println("@AfterReturning: JoinPoint: " + joinPoint + " - Result: " + result);
		
		convertAccountNamesToUpperCase(result);
	}
	
	@AfterThrowing(
		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
		throwing="e"
	)
	public void afterThrowingExample(JoinPoint joinPoint, Throwable e) {
		System.out.println("@AfterThrowing: JoinPoint: " + joinPoint + " - Exception: " + e);
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyExample(JoinPoint joinPoint) {
		System.out.println("@After: JoinPoint: " + joinPoint);
	}

	private void convertAccountNamesToUpperCase(List<Account> accounts) {
		for (Account account : accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}

}
