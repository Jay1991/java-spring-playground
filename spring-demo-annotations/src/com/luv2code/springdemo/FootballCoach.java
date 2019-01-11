package com.luv2code.springdemo;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	
	public FootballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Score 100 penalties!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
