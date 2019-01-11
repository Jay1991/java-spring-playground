package com.luv2code.springdemo;

public class StrangeFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "you will find a giant ball of paperclips rolling out in the street";
	}

}
