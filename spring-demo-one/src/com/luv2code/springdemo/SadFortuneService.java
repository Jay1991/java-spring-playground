package com.luv2code.springdemo;

import java.util.Random;

public class SadFortuneService implements FortuneService {
	
	private String[] fortunes = {
		"A pidgeon will shit on your head!",
		"You will step on a shit!",
		"You will lose 5 bucks!"
	};

	@Override
	public String getFortune() {
		Random index = new Random();
		return fortunes[index.nextInt(3)];
	}

}
