package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyFortuneService implements FortuneService {

	@Value("${fortuneOne}")
	private String fortuneOne;
	@Value("${fortuneTwo}")
	private String fortuneTwo;
	@Value("${fortuneThree}")
	private String fortuneThree;
	private String[] fortunes;
	private Random random = new Random();
	
	@PostConstruct
	public void setupData() {
		this.fortunes = new String[3];
		this.fortunes[0] = fortuneOne;
		this.fortunes[1] = fortuneTwo;
		this.fortunes[2] = fortuneThree;
	}
	
	
	@Override
	public String getFortune() {
		int index = this.random.nextInt(this.fortunes.length);
		return this.fortunes[index];
	}

}
