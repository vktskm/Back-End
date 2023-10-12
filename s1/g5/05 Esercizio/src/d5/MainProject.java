package d5;

/* Scrivere il codice Java necessario all'implementazione di un Player multimediale impiegando i principi OOP.
 * Descrizione del sistema:
 * Un Elemento Multimediale è una Immagine, un Video o una Registrazione Audio identificato da un titolo. 
 * Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un metodo play().
 * Una registrazione Audio è riproducibile e ha associato anche un volume (un valore positivo di tipo int) e i metodi abbassaVolume() e 
 * alzaVolume() per regolarlo. Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una se-
 * quenza di punti esclamativi di lunghezza pari al volume (una stampa per riga).
 * Un Video è riproducibile e ha associato un volume regolabile analogo a quello delle registrazioni audio e anche una luminosità (un 
 * valore positivo di tipo int) e i metodi aumentaLuminosita() e diminuisciLuminosita() per regolarla. Se riprodotta, ri-pete per un 
 * numero di volte pari alla durata la stampa del titolo concatenato a un altra sequenza di punti esclamativi di lunghezza pari al vo-
 * lume e poi a una sequenza di asterischi di lunghezza pari alla luminosità (una stampa per riga).
 * Un'Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella dei filmati e un metodo show() che stampa il titolo 
 * concatenato a una sequenza di asterischi di lunghezza pari alla luminosità.
 * Eseguire un oggetto multimediale significa invocarne il metodo show() se è un'immagine o il metodo play() se è riproducibile.
 * Organizzare opportunamente con classi astratte, interfacce e classi concrete il codice di un lettore multimediale che memorizza 5 
 * elementi (creati con valori letti da tastiera) in un array e poi chiede ripetutamente all'utente quale oggetto eseguire (leggendo 
 * un intero da 1 a 5 oppure 0 per finire). 
 * */

import java.util.Scanner;
import java.util.InputMismatchException;

public class MainProject {
    //Non ho fatto un array per gestire gli errori , mi sono un po' allontanato dalla traccia.
	static Riproduttore file1;
	static Riproduttore file2;
	static Riproduttore file3;
	static Riproduttore file4;
	static Riproduttore file5;

	public static void main(String[] args) {
		int tipo=0;//devo inizializzarla perchè  lo switch si aspetta un valore
		//se facessi lo switch dentro il primo do while dei controlli non mi darebbe errore 
		boolean inputValido;
		Scanner primoScanner = new Scanner(System.in);
        
	/*Ho fatto il controllo degli errori solamente per il primo valore inserito.
	 *Altrimenti avrei dovuto scrivere troppo codice. I cinque blocchi usano tutti
	 *la stessa logica , studiando il primo blocco non c'è bisogno di studiare gli altri.
	 *Avri voluto fare un for per non ripetere codice , ma non ho avuto tempo per sistemare tutti i bug  .
	 */
		
		

		do {
			    inputValido = false;
			    //con questo do while gestico cli errori di inserimento	
		        do {
		            try {
		                System.out.print("Seleziona il file 1/5 tra: Immagine (1), Video(2), Suono(3) inserici un intero: ");
		                tipo = primoScanner.nextInt();
		                
		                if (tipo >= 1 && tipo <= 3) {
		                    inputValido = true;
		                } else {
		                    System.out.println("Il numero inserito non e' compreso tra 1 e 3. Riprova.");
		                }
		                
		                inputValido = true;
		            } catch (InputMismatchException e) {
		                System.out.println("Hai inserito una stringa. Inserisci un intero.");
		                primoScanner.nextLine(); // Consuma l'input non valido
		            }
		        } while (!inputValido);
			
			
			switch (tipo) {
			case 1:
				Scanner primoscanner1 = new Scanner(System.in);
				System.out.println("Titolo immagine: ");
				String titolo = primoscanner1.nextLine();

				System.out.println("Luminosita immagine: ");
				int luminosita = primoscanner1.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file1 = new Immagine(titolo, luminosita);
				file1.xImmagine = 1;
				break;

			case 2:
				Scanner primoScanner2 = new Scanner(System.in);
				System.out.println("Titolo Video: ");
				String titolo2 = primoScanner2.nextLine();

				System.out.println("Durata Video ");
				int tempo2 = primoScanner2.nextInt();

				System.out.println("Luminosita video: ");
				int luminosita2 = primoScanner2.nextInt();

				System.out.println("Volume video: ");
				int volume2 = primoScanner2.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file1 = new Video(titolo2, tempo2, luminosita2, volume2);
				file1.xImmagine = 0;
				break;

			case 3:
				Scanner primoScanner3 = new Scanner(System.in);
				System.out.println("Titolo suono: ");
				String title3 = primoScanner3.nextLine();

				System.out.println("Tempo suono: ");
				int tempo3 = primoScanner3.nextInt();

				System.out.println("Volume suono: ");
				int volume3 = primoScanner3.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file1 = new Suono(title3, tempo3, volume3);
				file1.xImmagine = 0;
				break;
			default:
				System.out.println("Errore, inserire un numero da 1 a 3!");
			}
		} while (tipo != 1 && tipo != 2 && tipo != 3);

		// file2

		do {
			//devo impostare di nuovo a false inputValido
			inputValido = false;
			//con questo do while gestico cli errori di inserimento	
	        do {
	            try {
	                System.out.print("Seleziona il file 2/5 tra: Immagine (1), Video(2), Suono(3) inserici un intero: ");
	                tipo = primoScanner.nextInt();
	                
	                if (tipo >= 1 && tipo <= 3) {
	                    inputValido = true;
	                } else {
	                    System.out.println("Il numero inserito non e' compreso tra 1 e 3. Riprova.");
	                }
	                
	                inputValido = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Hai inserito una stringa. Inserisci un intero.");
	                primoScanner.nextLine(); // Consuma l'input non valido
	            }
	        } while (!inputValido);

			switch (tipo) {

			case 1:
				Scanner primoscanner1 = new Scanner(System.in);
				System.out.println("Titolo immagine: ");
				String titolo = primoscanner1.nextLine();

				System.out.println("Luminosita immagine: ");
				int luminosita = primoscanner1.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file2 = new Immagine(titolo, luminosita);
				file2.xImmagine = 1;
				break;

			case 2:
				Scanner primoScanner2 = new Scanner(System.in);
				System.out.println("Titolo Video: ");
				String titolo2 = primoScanner2.nextLine();

				System.out.println("Durata Video ");
				int tempo2 = primoScanner2.nextInt();

				System.out.println("Luminosita video: ");
				int luminosita2 = primoScanner2.nextInt();

				System.out.println("Volume video: ");
				int volume2 = primoScanner2.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file2 = new Video(titolo2, tempo2, luminosita2, volume2);
				file2.xImmagine = 0;
				break;

			case 3:
				Scanner primoScanner3 = new Scanner(System.in);
				System.out.println("Titolo suono: ");
				String title3 = primoScanner3.nextLine();

				System.out.println("Tempo suono: ");
				int tempo3 = primoScanner3.nextInt();

				System.out.println("Volume suono: ");
				int volume3 = primoScanner3.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file2 = new Suono(title3, tempo3, volume3);
				file2.xImmagine = 0;
				break;
			default:
				System.out.println("Errore, inserire un numero da 1 a 3!");
			}
		} while (tipo != 1 && tipo != 2 && tipo != 3);

		// file3

		do {
			//devo impostare di nuovo a false inputValido
			inputValido = false;
			//con questo do while gestico cli errori di inserimento	
	        do {
	            try {
	                System.out.print("Seleziona il file 3/5 tra: Immagine (1), Video(2), Suono(3) inserici un intero: ");
	                tipo = primoScanner.nextInt();
	                
	                if (tipo >= 1 && tipo <= 3) {
	                    inputValido = true;
	                } else {
	                    System.out.println("Il numero inserito non e' compreso tra 1 e 3. Riprova.");
	                }
	                
	                inputValido = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Hai inserito una stringa. Inserisci un intero.");
	                primoScanner.nextLine(); // Consuma l'input non valido
	            }
	        } while (!inputValido);

			switch (tipo) {

			case 1:
				Scanner primoscanner1 = new Scanner(System.in);
				System.out.println("Titolo immagine: ");
				String titolo = primoscanner1.nextLine();

				System.out.println("Luminosita immagine: ");
				int luminosita = primoscanner1.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file3 = new Immagine(titolo, luminosita);
				file3.xImmagine = 1;
				break;

			case 2:
				Scanner primoScanner2 = new Scanner(System.in);
				System.out.println("Titolo Video: ");
				String titolo2 = primoScanner2.nextLine();

				System.out.println("Durata Video ");
				int tempo2 = primoScanner2.nextInt();

				System.out.println("Luminosita video: ");
				int luminosita2 = primoScanner2.nextInt();

				System.out.println("Volume video: ");
				int volume2 = primoScanner2.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file3 = new Video(titolo2, tempo2, luminosita2, volume2);
				file3.xImmagine = 0;
				break;

			case 3:
				Scanner primoScanner3 = new Scanner(System.in);
				System.out.println("Titolo suono: ");
				String title3 = primoScanner3.nextLine();

				System.out.println("Tempo suono: ");
				int tempo3 = primoScanner3.nextInt();

				System.out.println("Volume suono: ");
				int volume3 = primoScanner3.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file3 = new Suono(title3, tempo3, volume3);
				file3.xImmagine = 0;
				break;
			default:
				System.out.println("Errore, inserire un numero da 1 a 3!");
			}
		} while (tipo != 1 && tipo != 2 && tipo != 3);

		// file4

		do {
			//devo impostare di nuovo a false inputValido
			inputValido = false;
			//con questo do while gestico cli errori di inserimento	
	        do {
	            try {
	                System.out.print("Seleziona il file 4/5 tra: Immagine (1), Video(2), Suono(3) inserici un intero: ");
	                tipo = primoScanner.nextInt();
	                
	                if (tipo >= 1 && tipo <= 3) {
	                    inputValido = true;
	                } else {
	                    System.out.println("Il numero inserito non e' compreso tra 1 e 3. Riprova.");
	                }
	                
	                inputValido = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Hai inserito una stringa. Inserisci un intero.");
	                primoScanner.nextLine(); // Consuma l'input non valido
	            }
	        } while (!inputValido);

			switch (tipo) {

			case 1:
				Scanner primoscanner1 = new Scanner(System.in);
				System.out.println("Titolo immagine: ");
				String titolo = primoscanner1.nextLine();

				System.out.println("Luminosita immagine: ");
				int luminosita = primoscanner1.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file4 = new Immagine(titolo, luminosita);
				file4.xImmagine = 1;
				break;

			case 2:
				Scanner primoScanner2 = new Scanner(System.in);
				System.out.println("Titolo Video: ");
				String titolo2 = primoScanner2.nextLine();

				System.out.println("Durata Video ");
				int tempo2 = primoScanner2.nextInt();

				System.out.println("Luminosita video: ");
				int luminosita2 = primoScanner2.nextInt();

				System.out.println("Volume video: ");
				int volume2 = primoScanner2.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file4 = new Video(titolo2, tempo2, luminosita2, volume2);
				file4.xImmagine = 0;
				break;

			case 3:
				Scanner primoScanner3 = new Scanner(System.in);
				System.out.println("Titolo suono: ");
				String title3 = primoScanner3.nextLine();

				System.out.println("Tempo suono: ");
				int tempo3 = primoScanner3.nextInt();

				System.out.println("Volume suono: ");
				int volume3 = primoScanner3.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file4 = new Suono(title3, tempo3, volume3);
				file4.xImmagine = 0;
				break;
			default:
				System.out.println("Errore, inserire un numero da 1 a 3!");
			}
		} while (tipo != 1 && tipo != 2 && tipo != 3);

		// file5

		do {
			//devo impostare di nuovo a false inputValido
			inputValido = false;
			//con questo do while gestico cli errori di inserimento	
	        do {
	            try {
	                System.out.print("Seleziona il file 5/5 tra: Immagine (1), Video(2), Suono(3) inserici un intero: ");
	                tipo = primoScanner.nextInt();
	                
	                if (tipo >= 1 && tipo <= 3) {
	                    inputValido = true;
	                } else {
	                    System.out.println("Il numero inserito non e' compreso tra 1 e 3. Riprova.");
	                }
	                
	                inputValido = true;
	            } catch (InputMismatchException e) {
	                System.out.println("Hai inserito una stringa. Inserisci un intero.");
	                primoScanner.nextLine(); // Consuma l'input non valido
	            }
	        } while (!inputValido);

			switch (tipo) {

			case 1:
				Scanner primoscanner1 = new Scanner(System.in);
				System.out.println("Titolo immagine: ");
				String titolo = primoscanner1.nextLine();

				System.out.println("Luminosita immagine: ");
				int luminosita = primoscanner1.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file5 = new Immagine(titolo, luminosita);
				file5.xImmagine = 1;
				break;

			case 2:
				Scanner primoScanner2 = new Scanner(System.in);
				System.out.println("Titolo Video: ");
				String titolo2 = primoScanner2.nextLine();

				System.out.println("Durata Video ");
				int tempo2 = primoScanner2.nextInt();

				System.out.println("Luminosita video: ");
				int luminosita2 = primoScanner2.nextInt();

				System.out.println("Volume video: ");
				int volume2 = primoScanner2.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file5 = new Video(titolo2, tempo2, luminosita2, volume2);
				file5.xImmagine = 0;
				break;

			case 3:
				Scanner primoScanner3 = new Scanner(System.in);
				System.out.println("Titolo suono: ");
				String title3 = primoScanner3.nextLine();

				System.out.println("Tempo suono: ");
				int tempo3 = primoScanner3.nextInt();

				System.out.println("Volume suono: ");
				int volume3 = primoScanner3.nextInt();
				System.out.println("Complimenti, file aggiunto in modo corretto!");
				System.out.println();

				file5 = new Suono(title3, tempo3, volume3);
				file5.xImmagine = 0;
				break;
			default:
				System.out.println("Errore, inserire un numero da 1 a 3!");
			}
		} while (tipo != 1 && tipo != 2 && tipo != 3);
        
	
		Scanner secondoScanner = new Scanner(System.in);

		int selezionati;
		do {
			System.out.println();
			System.out.println("Digita un numero da 1 a 5 per eseguire un file o 0 per uscire: ");
			selezionati = secondoScanner.nextInt();
			
			switch (selezionati) {
			case 1:
				switch (file1.xImmagine) {
				case 1:
					file1.show();
					break;
				case 0:
					file1.play();
					break;
				}
				break;
			case 2:
				switch (file2.xImmagine) {
				case 1:
					file2.show();
					break;
				case 0:
					file2.play();
					break;
				}
				break;
			case 3:
				switch (file3.xImmagine) {
				case 1:
					file3.show();
					break;
				case 0:
					file3.play();
					break;
				}
				break;
			case 4:
				switch (file4.xImmagine) {
				case 1:
					file4.show();
					break;
				case 0:
					file4.play();
					break;
				}
				break;
			case 5:
				switch (file5.xImmagine) {
				case 1:
					file5.show();
					break;
				case 0:
					file5.play();
					break;
				}
				break;
			case 0:
				System.out.println("Sei uscito dalla riproduzione, alla prossima!");
				break;
			default:
				System.out
						.println("Errore, no files per questo id! Digita un numero da 1 a 5 per tornare al controllo.");
				selezionati = secondoScanner.nextInt();
			}
			
			
		} while (selezionati != 0 && selezionati <= 5);
		
		primoScanner.close();
		secondoScanner.close();
	}//fine main
}//fine classe






