package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !getter() && !setter()")
	public void forDaoPackageNoGetterSetter() {}
}
