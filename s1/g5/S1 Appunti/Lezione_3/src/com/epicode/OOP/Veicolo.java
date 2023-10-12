package com.epicode.OOP;

public class Veicolo {
	
	private String marca; // -> private rende visibile il membro solo nella classe in cui l'ho definito
	public String modello; // -> public rende visibile il membro ovunque
	String targa; // -> package rende visibile il membro ovunque nel package in cui è stato definito
	
	public Veicolo() {}
	
	public Veicolo(String marca, String modello, String targa) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
	}
	
	// Getter e Setter
	public String getMarca() {
		// controlli
		return this.marca;
	}
	
	public void setMarca(String marca) {
		// controlli
		this.marca = marca;
	}
	
	

}
