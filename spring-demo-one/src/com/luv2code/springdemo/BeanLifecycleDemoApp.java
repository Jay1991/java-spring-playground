package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		boolean areTheSame = myCoach == alphaCoach; 
		
		System.out.println("myCoach workout: " + myCoach.getDailyWorkout());
		System.out.println("alphaCouch workout: " + alphaCoach.getDailyWorkout());
		System.out.println("are the same object: " + areTheSame);
		System.out.println("myCoach memory address: " + myCoach);
		System.out.println("alphaCoach memory address: " + alphaCoach);
		
		context.close();
	}

}
