package com.epicode.Spring.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserList {
	
	private String name = "Lista Utenti";
	private final List<User> userList = new ArrayList<User>();

}
