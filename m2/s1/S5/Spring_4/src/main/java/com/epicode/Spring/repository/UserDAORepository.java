package com.epicode.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epicode.Spring.model.User;

public interface UserDAORepository extends CrudRepository<User, Long> {

	public List<User> findByCity(String city);
	public List<User> findByNameAndLastname(String name, String lastname);
	public List<User> findByAgeBetween(Integer min, Integer max);
	
	@Query("SELECT u FROM User u WHERE u.age > :age")
	public List<User> findAllUserAge18(Integer age);
	
}
