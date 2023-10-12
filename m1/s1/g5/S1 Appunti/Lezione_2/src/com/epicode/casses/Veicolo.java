package com.epicode.casses;

public class Veicolo {

	public String marca;
	public String modello;
	public String targa;
	public static int num = 0; 
	
	// Costruttore senza parametri
	public Veicolo() {}
	
	// Costruttore con parametri
	public Veicolo(String marca, String modello, String targa) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		num++;
	}
	
	public void avviaVeicolo() {
		System.out.println("Veicolo avviato!!!");
	}
	
	public void fermaVeicolo() {
		System.out.println("Veicolo fermo!!");
	}
	
	public static void aggiornaVeicolo() {
		System.out.println("Veicolo aggiornato!!");
	}
	
	public Veicolo ritornaVeicolo() {
		// this è l'istanza che sto invocando
		return this;
	}
	
}
