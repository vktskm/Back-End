package com.epicode.interfaces;

public interface INavigatore {
	
	// Una interfaccia definisce solo metodi che poi andranno implementati in una classe
	// le interfacce supportano l'ereditarietà multipla a differenza delle classi
	
	public void startNavigatore();
	public void endNavigatore();
	public void impostaMappa();
	public void aggiornaNavigatore();

}
