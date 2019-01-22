package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectPointcuts {

	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void allMethods() { }
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() { }
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() { }
	
	@Pointcut("allMethods() && !(getter() || setter())")
	public void allMethodsExceptGettersAndSetters() { }

}
