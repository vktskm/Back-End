package com.epicode.Spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Spring.model.UserList;

@Configuration
public class UserListConfiguration {

	@Bean("userlist")
	@Scope("singleton")
	public UserList createUserList() {
		return new UserList();
	}
	
}
