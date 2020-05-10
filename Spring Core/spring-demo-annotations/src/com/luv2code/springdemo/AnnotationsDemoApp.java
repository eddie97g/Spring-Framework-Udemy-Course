package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach coach = context.getBean("swimCoach", Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}

}
