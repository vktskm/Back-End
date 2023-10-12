package com.epicode.classes;

abstract public class Veicolo {
	
	protected String marca; // -> protected rende visibile il membro ovunque nel package in cui è stato definito sia ad oggetti in altri package, purché essi siano estensioni della classe di riferimento.
	String modello; // -> package rende visibile il membro ovunque nel package in cui è stato definito
	private String targa; // -> private rende visibile il membro solo nella classe in cui l'ho definito
	public Alimentazione alimentazione; // -> public rende visibile il membro ovunque
	// Enum di tipo Alimentazione DIESEL,BENZINA,GAS,ELETTRICO
	
	public Veicolo(String marca, String modello, String targa, Alimentazione alimentazione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.alimentazione = alimentazione;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Alimentazione getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}
	
//	public void start() {
//		System.out.println("Start Veicolo!!!");
//	}
	
	// Metodo astratto
	public abstract void start();

	@Override
	public String toString() {
		return "Veicolo [marca=" + marca + ", modello=" + modello + ", targa=" + targa + ", alimentazione="
				+ alimentazione + "]";
	}

}
