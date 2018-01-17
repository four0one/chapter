package com.demo.study01;

import com.demo.study01.anno.RpcService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.lang.model.util.SimpleElementVisitor6;

@RpcService
public class PersonServiceImpl implements PersonService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void answer(String question) {
		if (StringUtils.isNotBlank(question)) {
			logger.info(question);
			logger.info("answer:{}","就不告诉你");
		}

	}
}
