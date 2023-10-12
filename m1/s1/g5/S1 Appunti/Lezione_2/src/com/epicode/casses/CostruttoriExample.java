package com.epicode.casses;

public class CostruttoriExample {
	
	public String testo;
	public int numero;
	
	// possso diversificare i costruttori in base alla firma
	// numero di parametri | tipo dei parametri | posisizione dei parametri
	
	// Costruttore di default
	public CostruttoriExample() {}
	
	// Costruttore con un solo parametro
	public CostruttoriExample(String testo) {
		this.testo = testo;
	}
	
	// Costruttore con un solo parametro
	public CostruttoriExample(int numero) {
		this.numero = numero;
	}
	
	// Costruttore con tutti i parametri
	public CostruttoriExample(String testo, int numero) {
		this.testo = testo;
		this.numero = numero;
	}
	
	// Costruttore con tutti i parametri
		public CostruttoriExample(int numero, String testo) {
			this.testo = testo;
			this.numero = numero;
		}

}
