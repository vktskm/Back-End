package main;

/*Esercizio 1
 * Creare una classe Rettangolo che permetta di rappresentare dei rettangoli.Per ogni rettangolo 
 * deve essere possibile specificare altezza e larghezza in fase di costruzione dell'istanza e 
 * devono essere realizzati i metodi per calcolare perimetro ed area.
 * Realizzare una funzione stampaRettangolo che, dato un rettangolo , stampi a video area e pe-
 * rimetro.
 * Realizzare una funzione stampaDueRettangoli che, dati due rettangoli, stampi area e perimetro 
 * di ognuno e quindi la somma delle aree e dei perimetri. 
 * Scrivere un main che utilizzi funzioni suddette.
 * */


public class MainOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Rettangolo rectangle = new Rettangolo(2,8);
		
        System.out.println("----- Area e Perimetro ------");
		
		System.out.println(rectangle.calcPerimetro());
		System.out.println(rectangle.calcArea());
		
		System.out.println("----- Print Rettangolo -----");
		
		Rettangolo.stampaRettangolo(rectangle);
		
		Rettangolo rectangleTwo = new Rettangolo(4,6);
		
		System.out.println("----- Print Due Rettangoli -----");
		
		
		Rettangolo.stampaDueRettangoli(rectangle,rectangleTwo);

	}

}
