package ES1;
/*Esercizio #1 - if-else if
 * Scrivere le seguenti funzioni:
 * stringaPariDispari, che accetta una stringa e ritorna true se il numero di caratteri è pari e false 
 * se il numero di caratteri è dispari.
 * - annoBisestile, che accetta un anno espresso come intero e ritorna true se esso è bisestile, false altrimenti.
 * - essere divisibile per 4
 * [Un anno per essere bisestile deve rispettare una delle seguenti regole: 
 * - qualora sia divisibile per 100 deve essere anche divisibile per 400
 * Scrivere una main che utilizzi le funzioni.
 * */

public class MainOne {
	public static void main(String[] args) {
		
		String pariDispari = "epicode";
		System.out.println(pariDispari + " " + CheckPari(pariDispari));
		
		int anno = 1700;
		System.out.println(anno + " " + CheckBisestile(anno));
		
	}
	
	public static boolean CheckPari(String pariDispari) {
			
			if(pariDispari.length() % 2 == 0) {
				return true;
			} else {
				return false;
			}
	}
	
	public static boolean CheckBisestile(int anno) {
		
		 if (anno % 4 == 0) {
		      if (anno % 100 == 0) {
		        if (anno % 400 == 0) {
		          return true;
		        } else {
		          return false;
		        }
		      } else {
		        return true;
		      }
		    } else {
		      return false;
		    }
	}

}
