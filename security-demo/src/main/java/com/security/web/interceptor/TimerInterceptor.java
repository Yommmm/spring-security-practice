package com.security.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Yom
 *
 */
@Component
public class TimerInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TimerInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("============afterCompletion============");
		long start = (long)request.getAttribute("startTime");
		logger.info("============afterCompletion time interceptor finish in =============={}", new Date().getTime() - start);
		System.out.println(ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
		logger.debug("============postHandler=============");
		long start = (long)request.getAttribute("startTime");
		logger.info("============postHandler time inteceptor finish in =============={}", new Date().getTime() - start);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler) throws Exception {
		logger.debug("=============preHandler============");
		logger.info("=============preHandler start time ==========={}", new Date().getTime());
		
		logger.info(((HandlerMethod)handler).getBean().getClass().getName());
		logger.info(((HandlerMethod)handler).getMethod().getName());
		
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

}
