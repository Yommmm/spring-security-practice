package com.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("login username: {}", username);
		User user = new User(username, 
				// "123456",
				passwordEncoder.encode("123456"),
				true, // 用户是否失效
				true, // 用户是否过期
				true, // 用户凭证是否过期
				true, // 用户是否被锁定
				AuthorityUtils.commaSeparatedStringToAuthorityList("admin")// 设置用户类型
				);
		return user;
	}

}
