package com.epicode.main;

import com.epicode.classes.Alimentazione;
import com.epicode.classes.Veicolo;

public class Test extends Veicolo {

	public Test(String marca, String modello, String targa, Alimentazione alimentazione) {
		super(marca, modello, targa, alimentazione);
	}

	public String testModificatori() {
		return "marca(protected): " + marca + " modello(package): " + " targa(private): " + "alimentazione(public): " + alimentazione;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
}
