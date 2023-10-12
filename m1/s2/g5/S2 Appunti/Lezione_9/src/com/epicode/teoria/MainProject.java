package com.epicode.teoria;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	public static List<String> lista = new ArrayList<String>();

	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(MainProject.class);
		
		log.info("Test Log");
		
		lista.add("Primo Valore");
		lista.add("Secondo Valore");
		lista.add("Terzo Valore");
		
//		for (String s : lista) {
//			System.out.println(s);
//		}
		
		// Lambda Expression
		// () -> System.out.println("Lambda Expression")
		// (s, g) -> System.out.println("Lambda Expression " + s + g)
		// s -> System.out.println("Lambda Expression " + s)
		
		//lista.forEach(e -> System.out.println(e));
		
		// Soluzione 1
		ClasseConcreta cc = new ClasseConcreta();
		stampaMessaggio(cc);
		
		// Soluzione 2
		stampaMessaggio(new ClasseConcreta());
		
		// Soluzione 3
		// Classe anonima che implementa IMessage direttamente negli argomenti del metodo stampamessaggio
		// è utile creare una classe anonima tutte quelle volte in cui devo utilizzare la classe una sola volta
		stampaMessaggio(new IMessage() {
			
			@Override
			public String getMesage() {
				return "ClasseAnonima message";
			}
			
		});
		
		// Soluzione 4
		// Quando abbiamo un interfaccia con un solo metodo (interfaccia funzionale)
		// abbiamo la possibilità di scrivere il codice tramite una lambda function	
		stampaMessaggio(() -> "LambdaFunction message");
		
		// Esempio di classi anonime e interfacce funzionali con Thread
		MioThread mt = new MioThread();
		Thread t1 = new Thread(mt);
		
		Thread t2 = new Thread(new MioThread());
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Sono un Thread Anonimo");
				
			}
		});
		
		Thread t4 = new Thread(
				() -> System.out.println("Sono un Lambda Thread"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
	
	public static void stampaMessaggio(IMessage c) {
		System.out.println(c.getMesage());
	}
	


}
