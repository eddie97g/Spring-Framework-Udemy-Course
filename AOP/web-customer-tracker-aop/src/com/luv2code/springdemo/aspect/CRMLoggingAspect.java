package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		logger.info("=====>>> in @Before: calling method: " + 
				joinPoint.getSignature().toShortString());
		Object[] args = joinPoint.getArgs();
		
		for(Object arg : args) {
			logger.info("=====>>> Arg: " + arg);
		}
	}
	
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		logger.info("=====>>> in @AfterReturning:  from method: " 
				+ joinPoint.getSignature().toShortString());
		
		logger.info("=====>>> Data returned: " + result);
	}
}
