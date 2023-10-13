package com.epicode.introSpring.DipendencyInjection;

public class Phone {
	
	private String operatore;
	private String numero;
	
	public Phone(String operatore, String numero) {
		super();
		this.operatore = operatore;
		this.numero = numero;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Phone [operatore=" + operatore + ", numero=" + numero + "]";
	}
	
	

}
