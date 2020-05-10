package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		
		System.out.println("Method: " + methodSignature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			System.out.println("arg: " + arg);
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				
				System.out.println("Name: " + account.getName());
				System.out.println("Level: " + account.getLevel());
			}
		}
		
		System.out.println("\n======>>> Performing API analytics");
	}
}
