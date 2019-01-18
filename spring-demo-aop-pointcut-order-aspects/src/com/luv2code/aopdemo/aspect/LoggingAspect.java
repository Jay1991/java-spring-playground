package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AspectPointcuts.allMethodsExceptGettersAndSetters()")
	public void logWhenNewAccountIsAdded() {
		System.out.println("New acount logged");
	}

}
