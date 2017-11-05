package com.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.security.vo.User;
import com.security.vo.UserQueryCondition;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition user, Pageable page){
		System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		List<User> list = new ArrayList<User>();
		list.add(new User());
		list.add(new User());
		list.add(new User());
		return list;
	}
	
	@GetMapping(value = "/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable(value = "id") String id) {
		User user = new User();
		user.setUsername("tom");
		return user;
	}

}
