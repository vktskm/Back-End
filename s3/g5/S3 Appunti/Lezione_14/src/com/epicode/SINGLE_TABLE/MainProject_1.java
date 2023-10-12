package com.epicode.SINGLE_TABLE;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainProject_1 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Lezione_14").createEntityManager();

	public static void main(String[] args) {

		Automobile_1 a1 = new Automobile_1();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setAlimentazione("Benzina");
		a1.setNporte(3);
		
		save(a1);
		
		Moto_1 m1 = new Moto_1();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(1);
		
		save(m1);

	}
	
	public static void save(Veicolo_1 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
