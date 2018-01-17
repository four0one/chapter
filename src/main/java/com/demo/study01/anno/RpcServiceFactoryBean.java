package com.demo.study01.anno;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

public class RpcServiceFactoryBean implements FactoryBean {

	private String className;

	@Override
	public Object getObject() throws Exception {
		Class innerClass = Class.forName(className);
		if (innerClass.isInterface()) {
//			return (T) InterfaceProxy.newInstance(innerClass);
			throw new Exception("不能作用在接口上");
		} else {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(innerClass);
			enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
			enhancer.setCallback(new Callback() {
			});
			return enhancer.create();
		}
	}

	@Override
	public Class<?> getObjectType() {
		try {
			return Class.forName(className).getClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
