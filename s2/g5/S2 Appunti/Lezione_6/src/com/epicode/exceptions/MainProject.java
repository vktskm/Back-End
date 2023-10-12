package com.epicode.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	public static void main(String[] args) {

		Logger log = LoggerFactory.getLogger(MainProject.class);
		
//		log.info("logInfo"); // -> invece che scrivere System.out.println("Messaggio");
//		log.debug("logDebug");
//		log.error("logError");
//		log.warn("logWarnig");
		
		Test t = new Test();
		// Se non gestisco le eccezioni nella classe Test 
		// queste risalgono per il concetto di propagazione fino al main
		t.test(); // // non gestisco ecc? questa blocca il mio software

	}

}
