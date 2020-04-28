package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		// call the business method
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		 
	
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}

}
