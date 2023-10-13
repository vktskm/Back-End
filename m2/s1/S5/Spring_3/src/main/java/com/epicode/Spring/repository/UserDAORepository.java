package com.epicode.Spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.epicode.Spring.model.User;

@Component
public class UserDAORepository implements IUserDAORepository {
	
	@Autowired JdbcTemplate jdbcTemplate;

	@Override
	public void create(User u) {
		
		// Creo una query SQL con dei segnaposto ? per ogni valore che voglio inserire nel DB
		String sql = " INSERT INTO public.user (name, lastname, city, age, email, password) "
				   + "VALUES (?, ?, ?, ?, ?, ?);";
		
		// Tramite l'ogg predefinito JdbcTemplate creo una connessione al DB, apro lo Statement con il DB
		// eseguo la query sql e sostituisco ai vari segnaposto i valori da salvare nel DB
		jdbcTemplate.update(sql, u.getName(), u.getLastname(), u.getCity(), u.getAge(), u.getEmail(), u.getPassword());
		
	}

	@Override
	public void update(User u) {
		// Creo una query SQL con dei segnaposto ? per ogni valore che voglio inserire nel DB
		String sql = " UPDATE public.user SET"
				   + " name = ?, lastname = ?, city = ?, age = ?, "
				   + " email = ? , password = ? WHERE id = ?";
				
		// Tramite l'ogg predefinito JdbcTemplate creo una connessione al DB, apro lo Statement con il DB
		// eseguo la query sql e sostituisco ai vari segnaposto i valori da salvare nel DB
		jdbcTemplate.update(sql,
						u.getName(), 
						u.getLastname(), 
						u.getCity(), 
						u.getAge(), 
						u.getEmail(), 
						u.getPassword(),
						u.getId());
	}

	@Override
	public void delete(Long id) {
		// Creo una query SQL con dei segnaposto ? per ogni valore che voglio inserire nel DB
		String sql = " DELETE FROM public.user WHERE id = ?";
						
		// Tramite l'ogg predefinito JdbcTemplate creo una connessione al DB, apro lo Statement con il DB
		// eseguo la query sql e sostituisco ai vari segnaposto i valori da salvare nel DB
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public User getById(Long id) {
		String sql = "SELECT * FROM public.user WHERE id = ?";
		User user =jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
		return user;
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM public.user";
		List<User> lista =jdbcTemplate.query(sql, new UserRowMapper());
		return lista;
	}

}
