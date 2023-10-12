package com.epicode.contocorrente;

public class MainProject {

	public static void main(String[] args) {

		Contocorrente rossi = new Contocorrente("Famiglia Rossi");
		Contocorrente verdi = new Contocorrente("Famiglia Verdi");
		rossi.deposito(400);
		verdi.deposito(500);
		
		Bancomat b1 = new Bancomat(rossi);
		Bancomat b2 = new Bancomat(rossi);
		Bancomat b3 = new Bancomat(verdi);
		
		b1.start();
		b2.start();

	}

}
