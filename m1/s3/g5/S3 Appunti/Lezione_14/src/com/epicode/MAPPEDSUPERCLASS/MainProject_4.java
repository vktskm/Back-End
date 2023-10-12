package com.epicode.MAPPEDSUPERCLASS;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MainProject_4 {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Lezione_14").createEntityManager();

	public static void main(String[] args) {

		Automobile_4 a1 = new Automobile_4();
		a1.setMarca("Fiat");
		a1.setModello("500");
		a1.setAlimentazione("Benzina");
		a1.setNporte(3);
		
		Automobile_4 a2 = new Automobile_4();
		a2.setMarca("Ford");
		a2.setModello("Fiesta");
		a2.setAlimentazione("Diesel");
		a2.setNporte(5);
		
		save(a2);
		
		Moto_4 m1 = new Moto_4();
		m1.setMarca("Honda");
		m1.setModello("Hornet");
		m1.setCilindrata("900cc");
		m1.setNposti(1);
		
		Moto_4 m2 = new Moto_4();
		m2.setMarca("Ducati");
		m2.setModello("Monster");
		m2.setCilindrata("1000cc");
		m2.setNposti(2);
		
		save(m2);

	}
	
	public static void save(Veicolo_4 v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
	}

}
