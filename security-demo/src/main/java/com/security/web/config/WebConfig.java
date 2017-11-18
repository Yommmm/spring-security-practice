package com.security.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.security.web.filter.TimerFilter;
import com.security.web.interceptor.TimerInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private TimerInterceptor timerInterceptor;
	
	@Bean
	public FilterRegistrationBean timeFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		TimerFilter timeFilter = new TimerFilter();
		registrationBean.setFilter(timeFilter);
		
		List<String> urls = new ArrayList<String>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timerInterceptor);
	}
	
}
