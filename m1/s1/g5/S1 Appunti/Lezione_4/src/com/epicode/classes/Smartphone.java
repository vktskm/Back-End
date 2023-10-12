package com.epicode.classes;

import com.epicode.interfaces.INavigatore;

public class Smartphone implements INavigatore {

	@Override
	public void startNavigatore() {
		System.out.println("Start Navigatore su Smartphone");
		
	}

	@Override
	public void endNavigatore() {
		System.out.println("End Navigatore su Smartphone");
		
	}

	@Override
	public void impostaMappa() {
		System.out.println("Mappa impostata su Smartphone");
		
	}

	@Override
	public void aggiornaNavigatore() {
		System.out.println("Navigatore aggiornato su Smartphone");
		
	}

}
