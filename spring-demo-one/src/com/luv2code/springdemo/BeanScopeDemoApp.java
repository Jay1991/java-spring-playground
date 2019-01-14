package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach myCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		System.out.println(alphaCoach.getDailyWorkout());
		System.out.println(alphaCoach.getDailyFortune());
		
		boolean areTheSame = myCoach == alphaCoach;
		
		System.out.println("Pointing to the same object: " + areTheSame);
		System.out.println("Memory location for myCoach: " + myCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
