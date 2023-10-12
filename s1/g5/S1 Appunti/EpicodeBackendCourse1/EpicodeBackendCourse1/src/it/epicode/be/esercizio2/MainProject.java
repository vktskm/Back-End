package it.epicode.be.esercizio2;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arrFive = {"Ciao", "Epicode", "Java", "Luglio", "Lezioni"};
		
		int resMoltiplica = moltiplica(10, 15);
		System.out.println(resMoltiplica);
		
		String resConcatena = concatena("Ciao", 15);
		System.out.println(resConcatena);

		String[] resInserisciInArray = inserisciInArray(arrFive, "Test");
		//System.out.println(resInserisciInArray);
		for (int i = 0; i < resInserisciInArray.length; i++) {
			System.out.print(resInserisciInArray[i]);
		}
	}
	
	public static int moltiplica(int x, int y) {
		return x * y; // Restituisce il prodotto dei parametri x e y
	}
	
	public static String concatena(String x, int y) {
		return x + y; // Restituisce la concatenazione dei parametri x e y
	}
	
	public static String[] inserisciInArray(String[] x, String y) {
		String[] arr = new String[6];
		// Soluzione 1
		arr[0] = x[0];
		arr[1] = x[1];
		arr[2] = x[2];
		arr[3] = y;
		arr[4] = x[3];
		arr[5] = x[4];
		
		// Soluzione 2
//		for(int i=0; i<x.length; i++) {
//			if(i == 3) {
//				arr[i] = y;
//			} else {
//				arr[i] = x [i];
//			}
//		}
		
		return arr;
	}

}
