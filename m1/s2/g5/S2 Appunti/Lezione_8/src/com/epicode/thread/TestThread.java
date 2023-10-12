package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Creo una classe che estende Thread
// ogni thread deve inserire la laogica nel metodo run ereditato
public class TestThread extends Thread {
	
	private Logger log = LoggerFactory.getLogger(TestThread.class);
	private String message;

	public TestThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		// Nel metodo Run della maia classe Thread vado ad inserire la logica
		// che il thread deve eseguire
		for(int i=0; i<=20; i++) {
			try {
				log.info("N." + i + " - " + message);
				if(i % 3 == 0) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
		}
	}
	
}
