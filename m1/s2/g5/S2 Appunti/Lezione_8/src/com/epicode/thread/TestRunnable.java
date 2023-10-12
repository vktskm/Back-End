package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRunnable implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(TestRunnable.class);
	private String message;

	public TestRunnable(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		// Nel metodo Run della maia classe Thread vado ad inserire la logica
		// che il thread deve eseguire
		for(int i=0; i<=20; i++) {
			try {
				log.info("N." + i + " - " + message);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
		}
		
	}

}
