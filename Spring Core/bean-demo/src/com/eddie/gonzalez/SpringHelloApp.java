package com.eddie.gonzalez;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		
		// Create container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Retrieve bean from container
		Coach coach = context.getBean("coach", Coach.class);
		// call bean method
		System.out.println(coach.getDailyWorkouts());
		System.out.println(coach.getDailyFortune());
		// close container
		context.close();

	}

}
