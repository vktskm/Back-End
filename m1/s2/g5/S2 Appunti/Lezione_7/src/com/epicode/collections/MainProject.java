package com.epicode.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static Logger log = LoggerFactory.getLogger(MainProject.class);

	public static void main(String[] args) {
		
//		log.debug("log.debug test");
//		log.info("log.info test");
//		log.warn("log.warning test");
//		log.error("log.error test");
		
		// metodi per i test delle collection e delle map
		
		//testCollection();
		//testList();
		//testSet();
		//testSortedSet();
		//testQueue();
		//testMap();
	}
	
	// Una Collection è una struttura dati che ha
	// non memorizza l'ordine in cui sono stati inseriti gli elementi
	// non definisce se ci possono essere valori duplicati
	// non può contenere valori primitivi
	public static void testCollection() {
		
		// Collection<int> i = new ArrayList<int>(); ERRORE!!! non è possibile inserire valori primitivi
		Collection<String> c = new ArrayList<String>();
		c.add("Primo Elemento");
		c.add("Secondo Elemento");
		c.add("Terzo Elemento");
		c.add("Primo Elemento");
		
		Object[] arr = c.toArray();
		for (Object s : arr) {
			log.info("Elemento: " + s.toString());
		}
		
		boolean b =  c.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento' " + b );
		
		boolean isEmp = c.isEmpty();
		log.info("Collection isEmpty " + isEmp );
		
		int size = c.size();
		log.info("Collection size " + size );
		
		c.remove("Secondo Elemento");
		
		log.info("Contains 'Secondo Elemento' " + c.contains("Secondo Elemento") );
		
		c.clear();
		
		log.info("Collection size " + c.size() );
	
	}
	
	// Una Lista è una struttura dati che eredita da Collection ed in più ha
	// gli oggetti sono ordinati in base all'ordine di inserimento
	// può contenere valori duplicati
	// consente di accedere ad un elemento in base all'indice
	public static void testList() {
		List<String> l = new ArrayList<String>();
		l.add("Primo Elemento");
		l.add("Secondo Elemento");
		l.add("Terzo Elemento");
		l.add("Primo Elemento");
		
		// metodi ereditati da Collection
		
		boolean b =  l.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento' " + b );
		
		boolean isEmp = l.isEmpty();
		log.info("List isEmpty " + isEmp );
		
		int size = l.size();
		log.info("List size " + size );
		
		l.remove("Secondo Elemento");
		
		log.info("Contains 'Secondo Elemento' " + l.contains("Secondo Elemento") );
		
		//l.clear();
		
		log.info("List size " + l.size() );
		
		// metodi di List
		
		String s = l.get(0);
		log.info("List indice 0: " + s );
		
		l.set(1, "Elemento modificato"); // modifica all'indice 1 il valore con "Elemento modificato"
		
		int index = l.indexOf("Terzo Elemento");
		log.info("Indice 'Terzo Elemento': " + index ); // -1 se non è presente
		
		Object[] arr = l.toArray();
		for(int i=0; i<l.size(); i++) {
			log.info("Elemento: " + l.get(i));
		}
		
	}

	// Un Set è una struttura dati che eredita da Collection ed in più ha
	// gli oggeti non sono ordinati
	// NON può contenere valori duplicati
	public static void testSet() {
		
		Set<String> s = new HashSet<String>();
		s.add("Primo Elemento");
		s.add("Secondo Elemento");
		s.add("Terzo Elemento");
		s.add("Primo Elemento"); // nel SET questo elemento non viene aggiunto perchè duplicato
				
		boolean b =  s.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento' " + b );
				
		boolean isEmp = s.isEmpty();
		log.info("Set isEmpty " + isEmp );
				
		int size = s.size();
		log.info("Collection size " + size );
				
		s.remove("Secondo Elemento");
				
		log.info("Contains 'Secondo Elemento' " + s.contains("Secondo Elemento") );
				
		//s.clear();
				
		log.info("Collection size " + s.size() );
		
		Object[] arr = s.toArray();
		for (Object e : arr) {
			log.info("Elemento: " + e.toString());
		}
	
	}
	
	// Un SortedSet è una sotto interfaccia che eredita da Set ed in più ha
	// gli oggeti sono ORDINATI tramite un indice
	// NON può contenere valori duplicati
	public static void testSortedSet() {
		SortedSet<String> s = new TreeSet<String>();
		s.add("Primo Elemento");
		s.add("Secondo Elemento");
		s.add("Terzo Elemento");
		s.add("Primo Elemento"); // nel SET questo elemento non viene aggiunto perchè duplicato
				
		boolean b =  s.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento' " + b );
				
		boolean isEmp = s.isEmpty();
		log.info("Set isEmpty " + isEmp );
				
		int size = s.size();
		log.info("Collection size " + size );
				
		s.remove("Secondo Elemento");
				
		log.info("Contains 'Secondo Elemento' " + s.contains("Secondo Elemento") );
				
		//s.clear();
				
		log.info("Collection size " + s.size() );
		
		Object[] arr = s.toArray();
		for (Object e : arr) {
			log.info("Elemento: " + e.toString());
		}
		
	}
	
	// Una Queue è una struttura dati che eredita da Collection ed in più ha
	// prevede operazioni di inserimento, rimozione e ispezione degli elementi 
	// l’ordinamento è tipicamente FIFO il primo che entra è il primo che esce
	public static void testQueue() {
		
		Queue<String> q = new LinkedList<String>();
		q.add("Primo Elemento");
		q.add("Secondo Elemento");
		q.add("Terzo Elemento");
		
		boolean b =  q.contains("Secondo Elemento");
		log.info("Contains 'Secondo Elemento' " + b );
		
		boolean isEmp = q.isEmpty();
		log.info("Queue isEmpty " + isEmp );
		
		int size = q.size();
		log.info("Queue size " + size );
		
		// metodi di Queue
		
		String primoPeek = q.peek();
		log.info("Queue primoPeek " + primoPeek ); // legge ma NON rimuove un elemento ad inizio coda
		
		String primoPool = q.poll();
		log.info("Queue primoPool " + primoPool ); // legge ma E rimuove un elemento ad inizio coda
		
		Object[] arr = q.toArray();
		for (Object s : arr) {
			log.info("Elemento: " + s.toString());
		}
		
	}
	
	// Una mappa è una struttura dati composta da chiave-valore di tipo eterogeneo.
	// ho la possibilità di accedere facilmente ad un valore tramite la sua chiave
	// non può contenere valori di tipo primitivo
	// gli oggeti NON sono ORDINATI
	public static void testMap() {
		Map<String, String> m = new HashMap<String, String>();
		
		// put così come add per le collection inserisce un elemento nella mappa
		// definendo una chiave ed un valore
		m.put("AB001", "Primo Elemento");
		m.put("AB002", "Secondo Elemento");
		m.put("AB003", "Terzo Elemento");
		
		// controlla se la mappa è vuota -> true o false
		log.info("Map isEmpty " + m.isEmpty() );
		
		// verifica se nella mappa è presente una chiave -> true o false
		log.info("Map Contains Key " + m.containsKey("AB002"));
		
		// legge un valore di una specifica chiave
		log.info("Map Key AB002 " + m.get("AB002"));
		
		// elimina un valoe nella mappa di una specifica chiave
		//m.remove("AB002");
		
		// mi restituisce il numero di elementi presenti in una mappa
		log.info("Map size " + m.size() );
		
		// mi restituisce un set di chiavi presenti in una mappa
		Set<String> key = m.keySet();
		// mi trasforma una Set in un array definito
		Object[] arr = key.toArray();
		// ciclo for che mi itera tutti gli elementi presenti in un array
		for (Object s : arr) {
			log.info("Elemento key: " + s + " Value: " + m.get(s));
		}

		// svuota completamente una mappa.
		m.clear();
	}

}
