package com.eddie.gonzalez;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach firstCoach = context.getBean("coach", Coach.class);
		Coach secondCoach = context.getBean("coach", Coach.class);
		
		if (firstCoach == secondCoach) {
			System.out.println("These objects are the same");
		}
		else {
			System.out.println("These are two different objects");
		}
		System.out.println("Memory address for firstCoach: " + firstCoach);
		System.out.println("Memory address for firstCoach: " + secondCoach);
		
		context.close();
	}

}
