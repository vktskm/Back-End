package com.epicode.Spring.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epicode.Spring.model.User;

@Repository
public interface IUserDAORepository {
	
	// in questa interfaccia DAO inserisco la dichiarazione 
	// di tutti i metodi di accesso al DB
	
	public void create(User u);
	public void update(User u);
	public void delete(Long id);
	public User getById(Long id);
	public List<User> getAll();

}
