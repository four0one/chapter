package com.demo.study01.anno;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class RpcServiceScanner extends ClassPathBeanDefinitionScanner {

	public RpcServiceScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	public void registerDefaultFilters() {
		this.addIncludeFilter(new AnnotationTypeFilter(RpcService.class));
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
		if(!CollectionUtils.isEmpty(beanDefinitionHolders)){
			for(BeanDefinitionHolder holder:beanDefinitionHolders){
				//TODO GenericBeanDefinition
				GenericBeanDefinition beanDefinition = (GenericBeanDefinition)holder.getBeanDefinition();
				beanDefinition.getPropertyValues().add("className",
						beanDefinition.getBeanClassName());
				beanDefinition.setBeanClass(RpcServiceFactoryBean.class);
			}
		}
		return null;
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return super.isCandidateComponent(beanDefinition)&& beanDefinition.getMetadata()
				.hasAnnotation(RpcService.class.getName());
	}
}
