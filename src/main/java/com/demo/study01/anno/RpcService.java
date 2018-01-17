package com.demo.study01.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RpcService {

	String value() default "";

	Class filter() default Object.class;
}
