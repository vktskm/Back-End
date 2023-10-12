package Es2;

/*Esercizio 2 
 * Implementare i seguenti metodi:
 * - Moltiplica: accetta due interi e ritorna il loro prodotto.
 * - Concatena: accetta una stringa e un intero e restituisce  una stringa che concatena gli elementi.
 * - InserisciArray: accetta un array di stringhe di cinque elementi ed una stringa e restituisce un 
 * array di sei elementi in cui la stringa passata sia al quarto posto e le stringhe precedentemente 
 * in quarta e quinta posizione siano rispettivamente in quinta e sesta.
 * 
 * Scrivere una main che invochi in sequenza i tre metodi realizzati.
 * */

public class MainProject2 {

	public static void main(String[] args) {
		//Dichiaro ed inizializzo un array di stringhe
		String[] arrFive = {"Luna", "Epicode", "Java", "Luglio", "Lezioni"};
		
		int resMoltiplica = moltiplica(10, 15);
		System.out.println( "Il risultato della moltiplicazione di 10 x 15 = " + resMoltiplica);
		
		String resConcatena = concatena("Ciao ", 15);
		System.out.println("Concatenazione di Ciao e 15 = " + resConcatena);

		String[] resArray = inserisciArray(arrFive, "Ciao");
		
		System.out.println( "Stampa array di Stringhe aggiungendo la stringa Ciao in posizione arr[3] : ");
		for (int i = 0; i < resArray.length; i++) {
			System.out.println(resArray[i]);
		}
	}
	
	/* La parola chiave static indica che il metodo appartiene alla classe stessa, non a una specifica 
	 * istanza dell'oggetto. Può essere richiamato direttamente utilizzando il nome della classe,senza 
	 * la necessità di creare un oggetto dell'istanza della classe.*/
	
	//Moltiplica: accetta due interi e ritorna il loro prodotto.
	public static int moltiplica(int x, int y) {
		return x * y; // Restituisce il prodotto dei parametri x e y
	}
    
	//Concatena: accetta una stringa e un intero e restituisce  una stringa che concatena gli elementi.
	public static String concatena(String x, int y) {
		return x + y; // Restituisce la concatenazione dei parametri x e y
	}
	
	/* InserisciArray: accetta un array di stringhe di cinque elementi ed una stringa e restituisce un 
	 * array di sei elementi in cui la stringa passata sia al quarto posto e le stringhe precedentemente 
	 * in quarta e quinta posizione siano rispettivamente in quinta e sesta.
	 * */
	public static String[] inserisciArray(String[] x, String y) {
	/* public static String[] inserisciArray(String[] x, String y)  
	 * Questa è la firma del metodo. Il metodo è pubblico (public), quindi può essere chiamato da 
	 * qualsiasi parte del codice. È dichiarato come statico (static), quindi può essere richiamato 
	 * direttamente senza la necessità di creare un'istanza dell'oggetto. 
	 * Prende in input un array di stringhe x e una stringa y. Restituisce un array di stringhe.
	 ***/

		String[] arr = new String[x.length + 1];
        /* String[] arr = new String[x.length + 1]; Viene creato un nuovo array di stringhe arr con una 
         * lunghezza pari a quella dell'array x incrementata di uno. Questo perché vogliamo inserire un 
         * nuovo elemento (y) nell'array arr.
         */
		
//      Soluzione 1
//		arr[0] = x[0];
//		arr[1] = x[1];
//		arr[2] = x[2];
//		arr[3] = y;
//		arr[4] = x[3];
//		arr[5] = x[4];
		
		// Soluzione 2
		for (int i = 0; i < arr.length; i++) {
            
			if (i < 3) {
                arr[i] = x[i];
            } else if (i == 3) {
                arr[i] = y;
            } else {
                arr[i] = x[i - 1];
            }
        }
		/* for (int i = 0; i < arr.length; i++){ 
		 * Questo è un ciclo for che itera su tutti gli elementi dell'array arr.
		 * if (i < 3)  
		 * All'interno del ciclo for, questo blocco di codice gestisce i primi tre elementi dell'array 
		 * arr (indice 0, 1 e 2). Assegna a arr[i] il valore corrispondente dell'array x.
		 * } else if (i == 3) { 
		 * Questa condizione è verificata quando l'indice i è uguale a 3,la quarta posizione dell'array 
		 * arr. In questa posizione, assegnamo il valore di y.
		 * } else { arr[i] = x[i - 1]}
		 * Questo blocco di codice gestisce gli elementi successivi dell'array arr (indice 4 e 5). 
		 * Assegna a arr[i] il valore dell'array x spostato di una posizione in avanti (perché stiamo 
		 * saltando la posizione 3, dove abbiamo inserito y).
		 * */
		
		return arr;
		/* Alla fine del metodo, viene restituito l'array arr, che ora contiene la stringa 
		 * y nella quarta posizione e le stringhe precedenti spostate come richiesto.
		 * */
	}

}
