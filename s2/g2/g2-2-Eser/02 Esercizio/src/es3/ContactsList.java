package es3;

import java.util.HashMap;
import java.util.Map;

public class ContactsList {

	private Map<String, String> ContactsList;

	public ContactsList() {
		ContactsList = new HashMap<String, String>();
	}

	public void addContact(String name, String number) {
		ContactsList.put(name, number);
	}

	public void deleteContact(String name) {
		ContactsList.remove(name);
	}

	public void searchContactByNumber(String number) {
		for (String name : ContactsList.keySet()) {
			if (ContactsList.get(name).equals(number)) {
				System.out.println(name + ":" + number);
			}
		}
	}

	public String searchContactByName(String name) {
		return ContactsList.get(name);
	}

	public void printContactsList() {
		System.out.println("Here's your contacts list: ");
		for (String name : ContactsList.keySet()) {
			String number = ContactsList.get(name);
			System.out.println(name + ": " + number);

		}

	}
}