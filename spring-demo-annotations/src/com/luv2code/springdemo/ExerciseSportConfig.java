package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExerciseSportConfig {
	
	@Bean
	public FortuneService strangeFortuneService() {
		return new StrangeFortuneService();
	}
	
	@Bean
	public Coach footballCoach() {
		return new FootballCoach(strangeFortuneService());
	}

}
