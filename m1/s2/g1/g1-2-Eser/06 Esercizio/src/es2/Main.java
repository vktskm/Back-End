package es2;

/*Esercizio #2
 * Scrivere un programma che permetta di calcolare il numero di km/litro percorsi 
 * da un'auto. Il programma riceve dall'utente il numero di km percorsi ed i litri
 * di carburante consumati e stampa i km/litro percorsi. 
 * Gestire per mezzo del try-catch l'eventualità che l'utente inserisca il valore 
 * 0 per il numero di litri consumati e venga generata una eccezione di divisione 
 * per zero.
 */
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

	private static Logger log = (Logger) LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		int km;
		int lt;

		Scanner input = new Scanner(System.in);

		log.info("How many km?");
		km = input.nextInt();
		log.info(km + "km");

		log.info("How many lt?");
		lt = input.nextInt();
		log.info(lt + "lt");

		consumi(km, lt);

		input.close();

	}

	public static void consumi(int km, int lt) {

		try {

			int consumi = km / lt;
			log.info("Consumption:" + consumi);

		} catch (ArithmeticException e) {

			log.warn("SOMETHING HAPPENED HERE: " + e.getMessage());

		}
    }

}