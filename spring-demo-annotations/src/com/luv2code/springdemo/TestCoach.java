package com.luv2code.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class TestCoach implements Coach {
	
	public TestCoach() {
		System.out.println("woooooooow");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct
	public void foo() {
		System.out.println("It is using eager loading!!!");
	}

}
