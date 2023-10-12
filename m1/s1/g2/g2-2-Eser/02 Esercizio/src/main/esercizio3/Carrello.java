package main.esercizio3;

import java.util.Arrays;

public class Carrello {
	
	Object[] elencoArticoli;
	double totaleCarrello;
	String cliente;
	
	public Carrello(String cliente, Object[] elencoArticoli, double totaleCarrello) {
		this.cliente = cliente;
		this.elencoArticoli = elencoArticoli;
		this.totaleCarrello = totaleCarrello;
	}
	
	
}

// Arrays.toString(carrello.elencoArticoli) + " "