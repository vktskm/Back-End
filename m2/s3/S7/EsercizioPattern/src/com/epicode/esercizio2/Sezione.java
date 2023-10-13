package com.epicode.esercizio2;

import java.util.List;

public class Sezione extends ElementoLibro {

	private String titolo;
	protected List<ElementoLibro> elementi;

	public Sezione(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public void stampa() {
		System.out.println("Titolo " + titolo);
		elementi.forEach(e -> e.stampa());
	}

	@Override
	public int numeroPagine() {
		return elementi.size();
	}
	
	
	
}
