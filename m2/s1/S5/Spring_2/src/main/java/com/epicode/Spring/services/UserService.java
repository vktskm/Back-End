package com.epicode.Spring.services;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.epicode.Spring.configuration.UserListConfiguration;
import com.epicode.Spring.model.User;
import com.epicode.Spring.model.UserList;

@Service
public class UserService {
	
	// Sfruttando la Dependency Injection vado a creare un oggetto di tipo Userlist
	// dal Bean @Bean("userlist") e lo incpsulo in un Container chiamato ObjectProvider
	@Autowired @Qualifier("userlist") private ObjectProvider<UserList> userListProvider;
	
	@Autowired @Qualifier("customUserBean") private ObjectProvider<User> customUserProvider;
	@Autowired @Qualifier("adminUserBean") private ObjectProvider<User> adminUserProvider;
	@Autowired @Qualifier("fakeUserBean") private ObjectProvider<User> fakeUserProvider;
	
	// Veccio modo per creare istanze da un bean ed inserirle in un Container
//	public void creaLista() {
//		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserListConfiguration.class);
//		lista = (UserList) appContext.getBean("createUserList");
//		appContext.close();
//	}
	
	public void addUserList(User u) {
//		UserList userlist = userListProvider.getObject();
//		String name = userlist.getName();
//		List<User> lista = userlist.getUserList();
//		lista.add(u);
		
		// Tutto quello che ho scritto sopra, posso riassumerlo in
		List<User> lista = userListProvider.getObject().getUserList();
		lista.add(u);
	}
	
	public void getUserList() {
		List<User> lista = userListProvider.getObject().getUserList();
		lista.forEach(u -> System.out.println(u));
	}
	
	public User createCustomUser(String name, String lastname, String city, Integer age, String email, String password) {
		User u = customUserProvider.getObject();
		
		// Inizializzo un ogg tramite i metodi set definiti nella classe POJO 
//		u.setName(name);
//		u.setLastname(lastname);
//		u.setCity(city);
//		u.setAge(age);
//		u.setEmail(email);
//		u.setPassword(password);
//		return u;
		
		// una alternativa è farlo tramite il Builder che mi mette a disposizione Lombok
		return u.builder()
					.name(name)
					.lastname(lastname)
					.city(city)
					.age(age)
					.email(email)
					.password(password)
					.build();
	}
	
	public User createFakeUser() {
		return fakeUserProvider.getObject();
	}

	public User createAdminUser() {
		return adminUserProvider.getObject();
	}

}
