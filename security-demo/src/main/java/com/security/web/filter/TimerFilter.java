package com.security.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TimerFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(TimerFilter.class);
	
	@Override
	public void destroy() {
		logger.info("=================TimeFilter destroy==================");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("==================TimeFilter start========================");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		long finish = new Date().getTime();
		logger.info("==================TimeFilter finish in {}", finish - start);
		logger.info("==================TimeFilter finish========================");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("===================TimeFilter init===================");
	}

}
