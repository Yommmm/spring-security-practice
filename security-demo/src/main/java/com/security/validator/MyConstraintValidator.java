package com.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	private static final Logger logger = LoggerFactory.getLogger(MyConstraintValidator.class);
	
	@Override
	public void initialize(MyConstraint arg0) {
		// TODO Auto-generated method stub
		logger.info("============My valiator init============");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		logger.info(value.toString());
		return false;
	}

}
