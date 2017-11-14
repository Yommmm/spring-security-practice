package com.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.security.service.HelloService;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	private static final Logger logger = LoggerFactory.getLogger(MyConstraintValidator.class);
	
	private HelloService helloService;
	
	@Override
	public void initialize(MyConstraint arg0) {
		logger.info("============My valiator init============");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		helloService.greeting("name");
		logger.info(value.toString());
		return false;
	}

}
