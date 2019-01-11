package com.luv2code.springdemo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortunes;
	private Random random = new Random();
	
    @Value("${fortunesFilePath}")
    private String fortunesFilePath;

    @PostConstruct
	public void setFortunes() {
		List<String> fortunes = Collections.emptyList();
		
		try {
			fortunes = Files.readAllLines(Paths.get(this.fortunesFilePath), StandardCharsets.UTF_8);
			this.fortunes = fortunes.toArray(String[]::new);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		return fortunes[random.nextInt(fortunes.length)];
	}

}
