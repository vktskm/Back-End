package com.epicode.classes;

public class Moto extends Veicolo {
	
	private boolean bauletto;

	public Moto(String marca, String modello, String targa, Alimentazione alimentazione, boolean bauletto) {
		super(marca, modello, targa, alimentazione);
		this.bauletto = bauletto;
	}

	public boolean isBauletto() {
		return bauletto;
	}

	public void setBauletto(boolean bauletto) {
		this.bauletto = bauletto;
	}
	
	@Override
	public void start() {
		System.out.println("Start Moto!!!");
	}

	@Override
	public String toString() {
		return "Moto [bauletto=" + bauletto + " " + super.toString() + " ]";
	}
	
	

}
