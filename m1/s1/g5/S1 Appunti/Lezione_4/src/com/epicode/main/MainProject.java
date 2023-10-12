package com.epicode.main;

import com.epicode.classes.Alimentazione;
import com.epicode.classes.Automobile;
import com.epicode.classes.Camper;
import com.epicode.classes.Moto;
import com.epicode.classes.Smartphone;
import com.epicode.classes.Veicolo;
import com.epicode.interfaces.INavigatore;

public class MainProject {

	public static void main(String[] args) {
		
		Automobile a1 = new Automobile("Fiat", "Panda", "AB123CD", Alimentazione.BENZINA , 3);
		Moto m1 = new Moto("Honda", "Hornet", "ZX789PO", Alimentazione.BENZINA, false);
		Camper c1 = new Camper("Elnagh", "XYZ", "XY456LK", Alimentazione.DIESEL, 5);
		//Veicolo v1 = new Veicolo(); // ERRORE una classe abstract non può essere istanziata
		Veicolo v1 = new Automobile("Ford", "Fiesta", "PO123RR", Alimentazione.DIESEL, 5);
		
		a1.getNumPorte();
		// v1.getNumPorte(); -> getNumPorte non è utilizzabile in un ogg ti tipo veicolo
		// v1.start();
		boolean b = v1 instanceof Automobile; // instanceof mi verifica se un oggetto è l'istanza di una classe
		Automobile a2 = (Automobile) v1;
		a2.getNumPorte();
		
		Veicolo[] arr = new Veicolo[5];
		arr[0] = a1; // Automobile che viene trattato come un Veicolo
		arr[1] = m1; // Moto che viene trattato come un Veicolo
		arr[2] = c1; // Camper che viene trattato come un Veicolo
		arr[3] = v1; // Automobile che viene trattato come un Veicolo
		arr[4] = a2; // Automobile che viene trattato come un Veicolo
		
		int auto = 0;
		int moto = 0;
		int camper = 0;
		
		for (int i = 0; i < arr.length; i++) {
			// compile time -> sono tutti oggetti di tipo Veicolo
			arr[i].start(); // run time -> scopre che si tratta di automobile.. camper.. moto.. ecc..
			if(arr[i] instanceof Automobile) {
				// Se l'oggetto che sto iterando è di tipo Automobile
				auto++;
				Automobile a = (Automobile) arr[i];
				System.out.println("Num. porte: " + a.getNumPorte());
			} else  if(arr[i] instanceof Moto) {
				// Se l'oggetto che sto iterando è di tipo Moto
				moto++;
				Moto m = (Moto) arr[i];
				System.out.println("Bauletto: " + m.isBauletto());
			} else if(arr[i] instanceof Camper) {
				// Se l'oggetto che sto iterando è di tipo Camper
				camper++;
				Camper c = (Camper) arr[i];
				System.out.println("Posti Letto: " + c.getPostiLetto());
			}
		
		}
		
		System.out.println("Automobili: " + auto + " Moto: " + moto + " Camper: " + camper) ;
		
//		System.out.println(a1);
//		System.out.println(m1);
//		System.out.println(c1);
//		
//		a1.start();
//		m1.start();
//		c1.start();
		
		Smartphone s1 = new Smartphone();
		
		// Array di oggetti che possiedo un navogatore quindi che implementano l'interfaccia INavigatore
		INavigatore[] oggNavigatore = new INavigatore[5];
		oggNavigatore[0] = s1; // Oggetto Smartphone che possiede un Navigatore
		oggNavigatore[1] = a1; // Oggetto Automobile che possiede un Navigatore
		
		for (int i = 0; i < oggNavigatore.length; i++) {
			// sui singoli oggetti posso invocare solo i metodi definiti nell'interfaccia INavigatore
			oggNavigatore[i].aggiornaNavigatore();
		}
		
	}

}
