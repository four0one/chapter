package com.demo.study01.anno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;


public class RpcServiceBeanPostProcessor extends ApplicationObjectSupport {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void initApplicationContext(ApplicationContext context) throws BeansException {
		Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(RpcService.class);
		beansWithAnnotation.keySet().forEach(beanName -> {
			Object bean = beansWithAnnotation.get(beanName);
			RpcService rpcServiceAnno = bean.getClass().getAnnotation(RpcService.class);
			Class filterClass = rpcServiceAnno.filter();
			Object filter = context.getBean(filterClass);
			logger.info("注册rpc方法");
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			for (Class inf : interfaces) {
				Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(inf);
				for (Method method : allDeclaredMethods) {
					logger.info("interfaceName:{} methodName:{}", inf.getName(), method.getName());
					RpcServiceContext.addRpcMapping(inf.getName() + "#" + method.getName(), bean);
				}
			}
		});
	}
}