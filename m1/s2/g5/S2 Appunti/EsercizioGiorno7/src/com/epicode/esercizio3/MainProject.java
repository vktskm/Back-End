package com.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainProject {
	
	private static Map<String, String> rubrica = new HashMap<String, String>();

	public static void main(String[] args) {

		try {
			aggiungiContatto("Mario Rossi", "123456789");
			aggiungiContatto("Luigi Verdi", "987654321");
			aggiungiContatto("Francesca Neri", "456321789");
			//aggiungiContatto("Mario Rossi", "123456789"); // Errore Chiave Duplicata
			
			stampaContatti();
			
			String nomeContatto = ricercaContattoDaNumero("456321789");
			System.out.println("Nome contatto: " + nomeContatto);
			
			String numeroContatto = ricercaContattoDaNome("Mario Rossi");
			System.out.println("Numero contatto: " + numeroContatto);
		
			rimuoviContatto("Luigi Verdi");
			// rimuoviContatto("Antonio Bianchi"); // Errore Chiave non presente in rubrica
		
			stampaContatti();
			
			System.out.println(rubrica.toString());
		
		} catch (ContainsKeyExceptions e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 1. L’inserimento di una coppia <Nome, telefono>
	public static void aggiungiContatto(String nome, String telefono) throws Exception {
		if(rubrica.containsKey(nome)) {
			throw new ContainsKeyExceptions("Chiave già presente nella rubrica!!!");
		} else {
			rubrica.put(nome, telefono);
			System.out.println("Contatto aggiunto in rubrica!");
		}
	}
	
	// 2. La cancellazione di una coppia <Nome, telefono> a partire dal nome
	public static void rimuoviContatto(String nome) throws Exception {
		if(rubrica.containsKey(nome)) {
			rubrica.remove(nome);
			System.out.println("Contatto rimosso dalla rubrica!");
		} else {
			throw new ContainsKeyExceptions("Chiave NON presente nella rubrica!!!");
		}
	}
	
	// 3. La ricerca di una Persona di cui si conosce il numero di telefono
	public static String ricercaContattoDaNumero(String numero){
		Set<String> key = rubrica.keySet();
		for (String k : key) {
			if(numero.equals(rubrica.get(k))) {
				return k;
			}
		}
		return null;
	}
	
	// 4. La ricerca del numero di telefono di una Persona di cui si conosce il Nome 
	public static String ricercaContattoDaNome(String nome){
		return rubrica.get(nome);
	}
	
	// 5. La stampa di tutti i contatti con nome e numero.
	public static void stampaContatti(){
		System.out.println("******* Contatti *********");
	    Set<String> key = rubrica.keySet();
	    for (String k : key) {
			System.out.println("Nome: " + k + " Numero: " + rubrica.get(k));
		}
	}

}
