package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static Logger log = LoggerFactory.getLogger(MainProject.class);

	public static void main(String[] args) throws InterruptedException {

		// Creo un Thread dalla classe TestThread
		TestThread t1 = new TestThread("Primo Thread");
		TestThread t2 = new TestThread("Secondo Thread");
		
		// Creo un Thread dalla classe TestRunnable
		// Creo un ogg dalla classe Runnable
		TestRunnable tr = new TestRunnable("Terzo Thread");
		// Utilizzo questo ogg come parametro della classe Thread
		Thread t3 = new Thread(tr); 
		// Creo un ogg dalla classe Runnable nel costruttore della classe Thread 
		Thread t4 = new Thread(new TestRunnable("Quarto Thread"));
		
		// Avvio un Thread (viene invocato in automatico il metodo run del thread)
		t1.start();
		// con il Join blocco l'esecuzione del resto del software fin quando 
		// la logica del thread è stato completata
		t1.join();
		t2.start();
		t3.start();
		t4.start();
		
		
		log.info("FINE");

	}

}
