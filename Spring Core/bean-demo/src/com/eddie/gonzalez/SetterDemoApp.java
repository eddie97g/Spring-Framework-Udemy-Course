package com.eddie.gonzalez;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach setterCoach = context.getBean("setterCoach", Coach.class);
		System.out.println(setterCoach.getDailyWorkouts());
		System.out.println(setterCoach.getDailyFortune());
		
		context.close();
		
		

	}

}
