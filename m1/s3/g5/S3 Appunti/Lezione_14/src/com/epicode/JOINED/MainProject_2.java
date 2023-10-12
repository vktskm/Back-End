package com.epicode.JOINED;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainProject_2 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Lezione_14").createEntityManager();

	public static void main(String[] args) {

		Automobile_2 a1 = new Automobile_2();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setAlimentazione("Benzina");
		a1.setNporte(3);
		
		save(a1);
		
		Moto_2 m1 = new Moto_2();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(1);
		
		save(m1);

	}
	
	public static void save(Veicolo_2 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
