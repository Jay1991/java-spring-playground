package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		System.out.println("tennisCoach");
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		System.out.println(tennisCoach.getEmail());
		System.out.println(tennisCoach.getTeam());
		System.out.println("memory location: " + tennisCoach);
		
		System.out.println("");
		
		TennisCoach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);
		System.out.println("alphaCoach");
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		System.out.println(tennisCoach.getEmail());
		System.out.println(tennisCoach.getTeam());
		System.out.println("memory location: " + alphaCoach);
		
		System.out.println("");
		System.out.println("are the same object? " + (tennisCoach == alphaCoach));
		
		context.close();
	}
}
