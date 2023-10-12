package es3;



public class ContoOnline extends ContoCorrente {

	double maxPrelievo;
	ContoOnline(String titolare, double saldo, double maxP) {
		super(titolare, saldo);
		this.maxPrelievo = maxP;
	}

	void stampaSaldo() {

		System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
				+ " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
	}
	
	/*Modificare il metodo preleva della sottoclasse ContoOnLine in modo che se 
	 * x>maxPrelievo viene lanciata una eccezione di tipo BancaException istanziando 
	 * l’eccezione con la stringa “il prelievo non è disponibile”.*/

	void preleva(double x) throws BancaException {
		if (x <= maxPrelievo) {
			super.preleva(x);
			
		} else if(x > maxPrelievo) {
			throw new BancaException("il prelievo non e' disponibile");
		}
	}
}

