package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RacingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run 10 laps in the course";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
