package com.epicode.esercizio;

public class MainProject {

	public static void main(String[] args) {

		Dipendente d1 = new Dipendente("AB001", Dipartimento.PRODUZIONE);
		d1.stampaDatiDipendente();
		Dipendente d2 = new Dipendente("AB002", 1300, 35, Livello.IMPIEGATO, Dipartimento.VENDITE);
		d2.stampaDatiDipendente();
		Dipendente d3 = new Dipendente("AB003", 1200, 35, Livello.IMPIEGATO, Dipartimento.PRODUZIONE);
		d3.stampaDatiDipendente();
		Dipendente d4 = new Dipendente("AB004", 2500, 50, Livello.DIRIGENTE, Dipartimento.AMMINISTRAZIONE);
		d4.stampaDatiDipendente();
		
		d2.promuovi();
		d2.stampaDatiDipendente();
		
		System.out.println(Dipendente.calcolaPaga(d1));
		System.out.println(Dipendente.calcolaPaga(d2, 3));
		System.out.println(Dipendente.calcolaPaga(d3, 5));
		System.out.println(Dipendente.calcolaPaga(d4));
		
	}

}
