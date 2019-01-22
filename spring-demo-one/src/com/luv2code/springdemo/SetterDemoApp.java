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
		
		doStuff(new Foo());

	}
	
	public static void doStuff(Foo instance) {
		System.out.println(instance.stuff());
	}

}

interface FooThing {
	String stuff();
}

class Foo implements FooThing {
	public String stuff() {
		return "stuff";
	}
}

class Bar extends Foo { }