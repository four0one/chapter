package com.demo.study01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

public class PersonAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws
			Throwable {
		logger.info("{}","英雄被枪毙");
	}

	@Override
	public void before(Method method, Object[] objects, Object o) throws Throwable {
		logger.info("{}","英雄被鬼子抓住了，汉奸问英雄");
	}
}
