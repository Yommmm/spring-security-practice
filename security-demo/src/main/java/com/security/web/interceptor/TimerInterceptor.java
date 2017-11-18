package com.security.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimerInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TimerInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object hander, Exception ex)
			throws Exception {
		logger.info("============afterCompletion============");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object hander, ModelAndView model)
			throws Exception {
		logger.info("============postHandler=============");
		
		logger.info("============start time =============={}",new Date().getTime());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object hander) throws Exception {
		logger.info("=============preHandler============");
		logger.info("=============start time ==========={}", new Date().getTime());
		request.setAttribute("startTime", new Date().getTime());
		return false;
	}

}
