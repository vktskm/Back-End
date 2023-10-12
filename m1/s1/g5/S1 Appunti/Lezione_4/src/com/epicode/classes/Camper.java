package com.epicode.classes;

public class Camper extends Veicolo {
	
	private int postiLetto;

	public Camper(String marca, String modello, String targa, Alimentazione alimentazione, int postiLetto) {
		super(marca, modello, targa, alimentazione);
		this.postiLetto = postiLetto;
	}

	public int getPostiLetto() {
		return postiLetto;
	}

	public void setPostiLetto(int postiLetto) {
		this.postiLetto = postiLetto;
	}
	
	@Override
	public void start() {
		System.out.println("Start Camper!!!");
	}

	@Override
	public String toString() {
		// non posso accedere alle proprietà definite nella classe veicolo perchè private
		return "Camper [postiLetto=" + postiLetto + " " + super.toString() + " ]";
	}
	
	

}
