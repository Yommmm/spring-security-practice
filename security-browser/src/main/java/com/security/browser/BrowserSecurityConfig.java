package com.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author Yom
 * WebSecurityConfigurerAdapter 适配器类
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 表单登录
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.httpBasic() //httpBasic方式登录
		http.formLogin() //表单方式登录
			.and()
			.authorizeRequests() //对请求进行授权
			.anyRequest() //任何请求
			.authenticated(); //都需要身份认证
	
	}

}
