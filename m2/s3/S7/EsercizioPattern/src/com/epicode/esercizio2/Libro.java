package com.epicode.esercizio2;

import java.util.List;

public class Libro {
	
	private String titolo;
	private Double prezzo;
	private List<String> autori;
	private List<ElementoLibro> elementi;

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public List<String> getAutori() {
		return autori;
	}



	public void setAutori(List<String> autori) {
		this.autori = autori;
	}



	public void stampa() {
		System.out.println("Libro " + titolo);
		elementi.forEach(ele -> ele.stampa());
	}

}
