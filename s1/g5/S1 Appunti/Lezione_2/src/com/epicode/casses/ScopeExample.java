package com.epicode.casses;

public class ScopeExample {
	
	// Variabile di istanza - scope di istanza
	// visibile ovunque nella classe
	public String scopeClasse;
	
	public void metodo1() {
		// scope di metodo
		// visibile solo nel metodo in cui è stata definita
		String scopeMetodo = "test";
		System.out.println(scopeClasse);
		System.out.println(scopeMetodo);
	}
	
	public void metodo2() {
		System.out.println(scopeClasse);
		// System.out.println(scopeMetodo); // Errore!!
		
		for (int i = 0; i < 1; i++) {
			// scope di blocco
			// visibile solo nel blocco in cui è stata definita
			String scopeBlocco = "test";
			System.out.println(scopeBlocco);
		}
		
		// System.out.println(scopeBlocco); // Errore!!
	}

}
