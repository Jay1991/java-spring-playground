package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CricketCoach myCoach = applicationContext.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getEmailAddress());
		System.out.println(myCoach.getTeam());
		
		applicationContext.close();

	}

}
