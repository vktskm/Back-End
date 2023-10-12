package com.epicode.JPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.MAPPEDSUPERCLASS.Automobile_4;

public class MainProject {
	
	static EntityManager em = Persistence.createEntityManagerFactory("Lezione_14").createEntityManager();

	public static void main(String[] args) {
		//List<Automobile_4> listaAuto = autoFindAll();
		//listaAuto.forEach(a -> System.out.println(a));

		//List<Automobile_4> listaAutoFord = autoByMarca("Ford");
		//listaAutoFord.forEach(a -> System.out.println(a));
		
		//Query q = em.createQuery("SELECT a FROM Automobile_4 a WHERE a.marca NOT IN ('Fiat', 'Ford', 'Bmw')");
		//List<Automobile_4> listaAuto = q.getResultList();
		//listaAuto.forEach( a-> System.out.println(a) );
		
		//Query q = em.createQuery("SELECT a FROM Automobile_4 a WHERE a.nporte IS NULL");
		//List<Automobile_4> listaAutoPorte = q.getResultList();
		//listaAutoPorte.forEach( a-> System.out.println(a) );
		
		//Query q = em.createQuery("SELECT MAX(a.nporte) FROM Automobile_4 a");
		
		Query q = em.createQuery("SELECT COUNT(a) FROM Automobile_4 a");
		
		System.out.println(q.getSingleResult());

		
		
		
	}
	
	public static List<Automobile_4> autoFindAll() {
		// "SELECT a FROM Automobile_4 a"
		Query q = em.createNamedQuery("Automobile.findAll");
		return q.getResultList();
	}
	
	public static List<Automobile_4> autoByMarca(String marca) {
		Query q = em.createNamedQuery("Automobile.findMarca");
		q.setParameter("marca_auto", marca);
		return q.getResultList();
	}
	
	public static List<Automobile_4> dinamicAutoByMarca(String marca) {
		// "SELECT a FROM Automobile_4 a WHERE a.marca LIKE :marca_auto"
		Query q = em.createQuery("SELECT a FROM Automobile_4 a WHERE a.marca LIKE :marca_auto");
		q.setParameter("marca_auto", marca);
		return q.getResultList();
	}
	

}
