package ES3;

/*Esercizio #3 - while
 * Scrivere un programma che chiede di inserire una stringa e la suddivida in caratteri separati dalla virgola. 
 * II programma si ripete fino a che l'utente non inserisce la stringa "q"
 * */
import java.util.Arrays;
import java.util.Scanner;


public class MainTre {
	
    public static void main(String[] args) {
        

        while (true) { 
        	System.out.print("Inserisci una stringa : ");
        	
        	Scanner sc = new Scanner(System.in);

        	String input = sc.nextLine();
        	
            if (input.equals("q")) {
                System.out.println("Hai inserito q ed esci dal ciclo");
                sc.close();
                break;
            }

            String[] characters = input.split("");
            System.out.println(Arrays.toString(characters));
                       
        }

    }
}