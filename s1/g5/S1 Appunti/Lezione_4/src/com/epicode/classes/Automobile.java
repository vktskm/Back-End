package com.epicode.classes;

import com.epicode.interfaces.INavigatore;

public class Automobile extends Veicolo implements INavigatore {
	
	private int numPorte;

	public Automobile(String marca, String modello, String targa, Alimentazione alimentazione, int numPorte) {
		super(marca, modello, targa, alimentazione);
		this.numPorte = numPorte;
	}

	public int getNumPorte() {
		return numPorte;
	}

	public void setNumPorte(int numPorte) {
		this.numPorte = numPorte;
	}
	
	public String testModificatori() {
		return "marca(protected): " + marca + " modello(package): " + modello + " targa(private): " + "alimentazione(public): " + alimentazione;
	}

	@Override
	public void start() {
		System.out.println("Start Automobile!!!");
	}

	@Override
	public String toString() {
		return "Automobile [numPorte=" + numPorte + " "+ super.toString() + " ]";
	}

	@Override
	public void startNavigatore() {
		System.out.println("Start Navigatore su Automobile");
		
	}

	@Override
	public void endNavigatore() {
		System.out.println("End Navigatore su Automobile");
		
	}

	@Override
	public void impostaMappa() {
		System.out.println("Mappa impostata su Automobile");
		
	}

	@Override
	public void aggiornaNavigatore() {
		System.out.println("Navigatore aggiornato su Automobile");
		
	}

}
