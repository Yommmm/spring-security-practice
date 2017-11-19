package com.security.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

	private static final Logger logger = LoggerFactory.getLogger(TimerAspect.class);
	
	@Around("execution(* com.security.controller.UserController.*(..))")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("============TimerAspect Start=============");
		
		Object[] args = pjp.getArgs();
		for(Object arg : args){
			logger.info("arg is: {}",arg);
		}
		
		long start = new Date().getTime();
		Object object = pjp.proceed();
		logger.info("time aspect 耗时：{}", (new Date().getTime() - start));
		logger.info("============TimerAspect Finish=============");
		
		return object;
	}
}
