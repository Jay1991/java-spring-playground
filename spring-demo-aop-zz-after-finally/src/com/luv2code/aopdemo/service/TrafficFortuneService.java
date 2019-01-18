package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneService {

	public String getFortune() {
		try {			
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Traffic will be free and easy today!";
	}
	
}
