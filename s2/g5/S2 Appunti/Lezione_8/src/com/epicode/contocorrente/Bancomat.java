package com.epicode.contocorrente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bancomat extends Thread {

	private Contocorrente conto;
	
	private Logger log = LoggerFactory.getLogger(Bancomat.class);

	public Bancomat(Contocorrente conto) {
		super();
		this.conto = conto;
	}
	
	public void preleva(double denaro) {
		if(conto.controlloSaldo(denaro)) {
			conto.prelievo(denaro);
			log.info("Prelievo effettuato su : " + this.conto);
		}
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			this.preleva(100);
		}
	}
	
	
	
}
