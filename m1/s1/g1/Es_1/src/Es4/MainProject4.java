package Es4;

/* Esercizio4
 * Implementare i seguenti metodi
 * - perimetroRettangolo che accetta la lunghezza decimale dei due lati di un rettangolo e ne calcola 
 * il perimetro.
 * - pariDispari che accetta un numero intero e restituisce 0 se il numero è pari e 1 se è dispari.
 * - perimetroRettangolo che accetta le lunghezze decimali dei lati di un triangolo e ne restituisca 
 * l'area (usare formula di Erone).
 * Scrivere una main che utilizzi in sequenza i tre metodi chiedendo l'input dei dati all'utente.
 * */


import java.util.Scanner;

public class MainProject4 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		calcolaPerimetroRettangolo();
		calcolaPariDispari();
		calcolaAreaTriangolo();	
	}
	

	/* perimetroRettangolo che accetta la lunghezza decimale dei due lati di un rettangolo e ne calcola 
	 * il perimetro.
	 */
	
	public static double perimetroRettangolo(double lato1, double lato2) {
		// La moltiplicazione ha precedenza sull'addizione
		double perimetro = lato1*2 + lato2*2;
		
		return perimetro;	
	}
	
	public static void calcolaPerimetroRettangolo() {
		
		System.out.println("----------------- Calcolo perimetro rettangolo -----------------");
		//Inserisci primo lato
		System.out.println("Primo lato(double .):");
		String lato1 = sc.nextLine();
		Double lato_1_doubled = Double.parseDouble(lato1);
		//inserisci secondo lato                  
		System.out.println("Secondo lato(double .):");
		String lato2 = sc.nextLine();
		Double lato_2_doubled = Double.parseDouble(lato2);
		//Calcola perimetro
		double perimetro = perimetroRettangolo(lato_1_doubled, lato_2_doubled);
		System.out.println("Perimetro rettangolo vale : " + perimetro );
		System.out.println("----------------------------------------------------------------");	    
	
	}
	
	
	//pariDispari che accetta un numero intero e restituisce 0 se il numero è pari e 1 se è dispari.	
	public static int pariDispari(int numero) {
		// l'operatore modulo (%) restituisce il resto della divisione di due numeri
		return ( numero % 2);
	}
	
	public static void calcolaPariDispari(){
		
		System.out.println("-----------------------  Pari o dispari -----------------------");
		//Inserisci numero intero
		System.out.println("Inserire un numero intero : ");
		String numero = sc.nextLine();
		Integer numero_int = Integer.parseInt(numero);
		//Calcola se il numero e' pari o dispari
		int paridispari = pariDispari(numero_int);
		System.out.println("0 se pari,1 se dispari. Il risultato e' " + paridispari);                                  
		System.out.println("----------------------------------------------------------------");
	}
	
	/* perimetroRettangolo che accetta le lunghezze decimali dei lati di un triangolo e ne restituisca 
     * l'area (usare formula di Erone).
     **/
	
	public static double areaTriangolo(double lato1,double lato2, double lato3) {
		// formula di Erone: area = sqrt( p*(p-lato1)*(p-lato2)*(p-lato3))
		// dove p è il semiperimetro del triangolo
		
		// Calcola il semiperimetro
		double p = (lato1 + lato2 + lato3)/2;
		//  calcola il radicando		
		double radicando = p*(p-lato1)*(p-lato2)*(p-lato3);
		// Calcola la radice quadrata usando la funzioneMath.sqrt()
		double area = Math.sqrt(radicando);
		
		return area;
	}
	
	public static void calcolaAreaTriangolo() {
		
		System.out.println("-------------------- Calcola area triangolo --------------------");
		//Inserisci primo lato
		System.out.println("Primo lato(double .):");
		String lato1 = sc.nextLine();
		Double lato_1_doubled = Double.parseDouble(lato1);
		//inserisci secondo lato                  
		System.out.println("Secondo lato(double .):");
		String lato2 = sc.nextLine();
	    Double lato_2_doubled = Double.parseDouble(lato2);
	    //Inserisci terzo lato
	  	System.out.println("Terzo lato(double .):");
	  	String lato3 = sc.nextLine();
	  	Double lato_3_doubled = Double.parseDouble(lato3);
	  	//	
		double area = areaTriangolo(lato_1_doubled, lato_2_doubled, lato_3_doubled);
		System.out.println("L'area triangolo e': " + area);
		System.out.println("----------------------------------------------------------------");
        
	}

}
