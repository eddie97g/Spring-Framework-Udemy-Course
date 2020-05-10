package com.eddie.gonzalez;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkouts() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return this.fortuneService.getFortune();
	}

}
