package com.epicode.iofile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	
	private static File file = new File("doc/test.txt");
	private static Logger log = LoggerFactory.getLogger(MainProject.class);

	public static void main(String[] args) {
		
		try {
			scriviSuFile("Ciao a tutti!!");
			System.out.println("Testo :" + leggidaFile());
			//cancellaFile();
		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}
	
	public static void scriviSuFile(String testo) throws IOException {
		// FileUtils.writeStringToFile scrive su un file
		// i parametri da passare sono 
		// 1 - il file su cui scrivere
		// 2 - il testo da scrivere
		// 3 - il charset di caratteri da utilizzare
		// 4 - (facoltativo) true se voglio appendere il testo ad un testo esistente nel file
		FileUtils.writeStringToFile(file, testo, "UTF-8", true); 
		log.info("Testo scritto su file " + file.getPath());
	}
	
	public static String leggidaFile() throws IOException {
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		return textFile;
	}

	public static void cancellaFile() throws IOException {
		FileUtils.deleteQuietly(file);
		log.info("File eliminato");
	}
}
