package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
    @Value("${foo.email}")
    private String email;
        
    @Value("${foo.team}")
    private String team;

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley for 1 hour!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("spring init bean for TennisCoach");
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("spring destroy bean for TennisCoach");
	}

}
