package com.eddie.gonzalez;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecyleDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		Coach coach = context.getBean("coach", Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		context.close();

	}

}
