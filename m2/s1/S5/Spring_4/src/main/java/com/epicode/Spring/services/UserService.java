package com.epicode.Spring.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.model.User;
import com.epicode.Spring.repository.UserDAORepository;

@Service
public class UserService {
	
	@Autowired UserDAORepository repo;
	
	@Autowired @Qualifier("customUserBean") private ObjectProvider<User> customUserProvider;
	@Autowired @Qualifier("adminUserBean") private ObjectProvider<User> adminUserProvider;
	@Autowired @Qualifier("fakeUserBean") private ObjectProvider<User> fakeUserProvider;

	// Create bean method
	
	public User createFakeUser() {
		return fakeUserProvider.getObject();
	}

	public User createAdminUser() {
		return adminUserProvider.getObject();
	}
	
	public User createCustomUser(String name, String lastname, String city, Integer age, String email, String password) {
		return customUserProvider.getObject().builder().name(name).lastname(lastname).city(city).age(age).email(email).password(password).build();
	}
	 
	// Create JDBC method
	
	public void createUser(User u) {
		repo.save(u);
		System.out.println(u.getName() + " " + u.getLastname() + " salvato nel DB!!!");
	}
	
	public void updateUser(User u) {
		repo.save(u);
		System.out.println(u.getName() + " " + u.getLastname() + " modificato nel DB!!!");
	}
	
	public void removeUser(User u) {
		repo.delete(u);
		System.out.println(u.getName() + " " + u.getLastname() + " eliminato dal DB!!!");
	}
	
	public User findUser(long id) {
		return repo.findById(id).get();
	}
	
	public List<User> findAllUser() {
		return (List<User>) repo.findAll();
	}
	
	public List<User> findUserMax(Integer age) {
		return repo.findAllUserAge18(age);
	}
	

}
