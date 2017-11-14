package com.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Yom
 *
 */

@Service
public class HelloServiceImpl implements HelloService {

	private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	@Override
	public String greeting(String name) {
		logger.info("hello " + name);
		return name;
	}

}
