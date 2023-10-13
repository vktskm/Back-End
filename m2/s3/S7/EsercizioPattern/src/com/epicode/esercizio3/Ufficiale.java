package com.epicode.esercizio3;

public abstract class Ufficiale {
	
	Ufficiale superiore = null;
	String funzioneSvolta = "";
	Double stipendio = 1000.00;
	
	public void setFunzioneSvolta(String funzioneSvolta) {
		this.funzioneSvolta = funzioneSvolta;
	}

	public void setSuperiore(Ufficiale superiore) {
		this.superiore = superiore;
	}
	
//
//	public void setStipendio(double stipendio) {
//		this.stipendio = stipendio;
//	}
	
	public void checkStipendio() {
		if(this instanceof Capitano) {
			this.stipendio = 1000.00;
		} else if(this instanceof Maggiore) {
			this.stipendio = 2000.00;
		} else if(this instanceof Tenente) {
			this.stipendio = 3000.00;
		} else if(this instanceof Colonnello) {
			this.stipendio = 4000.00;
		} else if(this instanceof Generale) {
			this.stipendio = 5000.00;
		}
	}

}
