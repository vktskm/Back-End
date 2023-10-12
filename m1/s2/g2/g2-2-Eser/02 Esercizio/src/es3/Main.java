package es3;

/* Esercizio #3
 * Scrivere una classe Java che permetta di gestire una rubrica telefonica. 
 * La lista dei contatti è realizzata mediante una HashMap in cui le chiavi sono i nomi 
 * delle persone e i valori sono i numeri di telefono. 
 * Realizzare i metodi per:
 * 1. L'inserimento di una coppia <Nome, telefono>
 * 2. La cancellazione di una coppia <Nome, telefono> a partire dal nome
 * 3. La ricerca di una Persona di cui si conosce il numero di telefono
 * 4. La ricerca del numero di telefono di una Persona di cui si conosce il Nome
 * 5. La stampa di tutti i contatti con nome e numero.*/

public class Main {

	public static void main(String[] args) {

		ContactsList contactsList = new ContactsList();

		contactsList.addContact("Enzo", "3275460000");
		contactsList.addContact("Andrea", "3467878000");
		contactsList.addContact("Umberto", "3452567789");
		contactsList.addContact("Giuseppe", "3452672100");
		contactsList.addContact("Giulia", "3425678600");

		contactsList.printContactsList();
		
        System.out.println("Delete contact Giulia");
		contactsList.deleteContact("Giulia");
		contactsList.printContactsList();
		
		System.out.println("Search contact 327546000");
		contactsList.searchContactByNumber("3275460000");

	}

}
