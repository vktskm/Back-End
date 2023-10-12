package com.epicode.OOP;

public class Automobile extends Object {
	
	private String marca; 
	private String modello; 
	private String targa;
	
	// Overloading dei Costruttori, si differenziano per la firma
	// la firma è composta dal numero di parametri, tipo e posizione
	// public Automobile() {} // Non è consigliabile IN QUESTO CASO
	
	// Overloading dei Costruttori
	public Automobile(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
	}

	// Overloading dei Costruttori
	public Automobile(String marca, String modello, String targa) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public String getModello() {
		return this.modello;
	}
	
	public String getTarga() {
		return this.targa;
	}
	
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	// overloading dei metodi si differenziano per la firma
	// la firma è composta dal numero di parametri, tipo e posizione
	public void manutenzione(int olio) {
		System.out.println("sostituito n." + olio + " di olio motore");
	}
	
	public void manutenzione(String filtro) {
		System.out.println("sostituito Filtro " + filtro);
	}
	
	public void manutenzione(int olio, String filtro) {
		System.out.println("sostituito n." + olio + " di olio motore + Filtro " + filtro);
	}
	
	// ridefinisco un metodo ereditato da Object
	@Override
	public String toString() {
		// return il riferimento alla zona di momoria in formato stringa
		return "Automobile: " + this.marca + " " + this.modello + " Targa: " + this.targa;
	}
}
