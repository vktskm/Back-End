package com.epicode.OOP;

public class MainOOP {

	public static void main(String[] args) {
		
		Veicolo v = new Veicolo();
		v.setMarca("Fiat"); // modificatore di accesso private
		v.modello = "500"; // modificatore di accesso public
		v.targa = "AB123CD"; // modificatore di accesso package
		
		Automobile v1 = new Automobile("Fiat", "Panda", "CD456EF");
		Automobile v2 = new Automobile("Ford", "Fiesta", "EE000FF");
		Automobile v3 = new Automobile("Bmw", "X5", "AB123CD");
		v1.manutenzione(3); // Overloading dei metodi -> int olio
		v2.manutenzione(1, "Antipolline"); // Overloading dei metodi -> int olio + String filtro
		v3.manutenzione("Antipolline"); // Overloading dei metodi -> String filtro
		Automobile[] arr = {v1, v2, v3};
		
		//System.out.println(v1.getMarca() + " " + v1.getModello() + " " + v1.getTarga());
		//v1.setTarga("EE000FF");
		//System.out.println(v1.getMarca() + " " + v1.getModello() + " " + v1.getTarga());
		//System.out.println(v1.toString());
		//System.out.println(v1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); // richiamo in automatico il metodo toString della classe automobile
		}
		
		
		// ENUM 
		String taglia;
		taglia = "L";
		taglia = "M";
		taglia = "XL";
		taglia = "pippo"; // Problema
		
		Colore c = Colore.VERDE; // Utilizzo di un ENUM
		inserisciColore(c); // Utilizzo di un ENUM
		inserisciColore(Colore.GIALLO); // Utilizzo di un ENUM
	}
	
	
	public static void inserisciColore(Colore colore) {
		System.out.println("Il colore inserito è " + colore);
	}

}
