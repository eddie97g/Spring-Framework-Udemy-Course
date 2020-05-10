package com.eddie.gonzalez;

public class BaseballCoach implements Coach{

	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkouts() {
		return "Batting practice for 30 min";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: " + fortuneService.getFortune();
	}
	
	public void BaseballCoachInitMethod() {
		System.out.println("We are inside the init method");
	}
	
	public void BaseballCoachDestroyMethod() {
		System.out.println("We are inside the destroy method");
	}
}
