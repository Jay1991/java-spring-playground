package com.luv2code.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today, you will step on a piece of shit! OMG!";
	}

}
