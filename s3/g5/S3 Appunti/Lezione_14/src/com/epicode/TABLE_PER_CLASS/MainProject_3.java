package com.epicode.TABLE_PER_CLASS;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainProject_3 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Lezione_14").createEntityManager();

	public static void main(String[] args) {
		
		Veicolo_3 v1 = new Veicolo_3();
		v1.setMarca("Test");
		v1.setModello("Test");
		
		save(v1);

		Automobile_3 a1 = new Automobile_3();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setAlimentazione("Benzina");
		a1.setNporte(3);
		
		save(a1);
		
		Moto_3 m1 = new Moto_3();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(1);
		
		save(m1);

	}
	
	public static void save(Veicolo_3 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
