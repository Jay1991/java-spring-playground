package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudLogAspect {

	@Before("com.luv2code.aopdemo.aspect.AspectPointcuts.allMethodsExceptGettersAndSetters()")
	public void logToCloud() {
		System.out.println("Entry logged into cloud");
	}

}
