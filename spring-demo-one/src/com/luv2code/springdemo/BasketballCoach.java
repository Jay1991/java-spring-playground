package com.luv2code.springdemo;

public class BasketballCoach implements Coach {

	private FortuneService fortuneService;
	
	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Score 200 points";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void init() {
		System.out.println("BasketballCoach bean initialization hook");
	}
	
	public void cleanup() {
		System.out.println("BasketballCoach bean destruction hook");
	}

}
