package com.eddie.gonzalez;

import java.util.ArrayList;
import java.util.Random;

public class WisdomFortuneService implements FortuneService {

	private ArrayList<String> fortunes;
	
	public WisdomFortuneService() {
		fortunes = new ArrayList<String>();
		fortunes.add("It's better to have 4 quarters than 100 pennies");
		fortunes.add("It's not what you know, it's who you know");
		fortunes.add("Live in the moment");
	}
	@Override
	public String getFortune() {
		int randomNumber = getRandomNumber();
		return fortunes.get(randomNumber);
	}
	
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(3);
	}

}
