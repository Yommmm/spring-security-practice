package com.security.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.security.web.filter.TimerFilter;

@Configuration
public class WebConfig {

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
}
