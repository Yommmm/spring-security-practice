package com.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Yom
 * WebSecurityConfigurerAdapter 适配器类
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * 表单登录
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic() //httpBasic方式登录
		http.formLogin() //表单方式登录
			.loginPage("/authentication/require") //指定登录页面
			.loginProcessingUrl("/authentication/form") //指定处理的过滤器
			.and()
			.authorizeRequests() //对请求进行授权
			.antMatchers("/authentication/require").permitAll() //过滤授权页面
			.anyRequest() //任何请求
			.authenticated() //都需要身份认证
			.and()
			.csrf().disable(); //跨站请求校验取消
	
	}

}
