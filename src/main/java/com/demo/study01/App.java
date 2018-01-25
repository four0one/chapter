package com.demo.study01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class App {

	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws NoSuchMethodException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext
				("classpath:spring-config-study01.xml");
		Object personService = applicationContext.getBean(PersonService.class);

		//代理
		ProxyFactory proxyFactory = new ProxyFactory(personService);
//		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
		advisor.setPattern(".*");
		advisor.setAdvice(new PersonAdvice());
		proxyFactory.addAdvisor(advisor);

		Object proxy = proxyFactory.getProxy();
		Method[] methods = PersonService.class.getMethods();
		Method answer = methods[0];
		ReflectionUtils.invokeMethod(answer,proxy,new Object[]{"八路在哪里"});

//		proxy.answer("八路在哪里");
	}
}
