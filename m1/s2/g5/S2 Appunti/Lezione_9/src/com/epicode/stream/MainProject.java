package com.epicode.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainProject {
	
	static List<String> lista1 = new ArrayList<String>();
	static List<String> lista2 = Arrays.asList("Test1", "Test2", "Test3");

	public static void main(String[] args) {
		
		lista1.add("Angular");
		lista1.add("React");
		lista1.add("Javascript");
		lista1.add("Typescript");
		lista1.add("Java");
		
		// Senza Stream
		List<String> newLista = new ArrayList<String>(); 
		for (String ele : lista1) {
			if(ele.length() >= 6) {
				newLista.add(ele + "!"); 
			}
		}
		
		// Stream
		Stream<String> s = lista1.stream(); // trasformo una collection in uno stream di dati
		Stream<String> sFilter = s.filter(ele -> ele.length() >= 6); // Angular - Javascript - Typescript
		Stream<String> sMod = sFilter.map(ele -> ele + "!");
		//sMod.forEach(ele -> System.out.println(ele));
		
		List<String> st = lista1.stream()
									.filter(ele -> ele.length() >= 6)
									.map(ele -> ele + "!")
									.sorted()
									.limit(2)
									.collect(Collectors.toList()); // Chiude uno stream e ne restiusce una collezione
		
		String sConc = lista1.stream()
				.filter(ele -> ele.length() >= 6) // filtra ogni elemento dello stream in base ad una condizione
				.map(ele -> ele + "!") // modifica ogni elemento dello stream
				.reduce("", (acc, ele) -> acc + ele + "#"); // reduce prende un flusso di dati e restituisce un solo valore. reduce prende come paramentro 2 valori, il valore iniziale dell'acc e la lambda che gestisce la logica per il risultato finale

		System.out.println(sConc);
		
		// Con il builder creo direttamente uno stream di dati 
		//List<Integer> listaNum = new ArrayList<Integer>();
		//List<Integer> listaNum = Arrays.asList(25, 15, 9, 31, 42, 3);
		//Stream<Integer> streamBuilder = listaNum.stream();	
		Stream<Integer> streamBuilder =  Stream.<Integer>builder()
													.add(25)
													.add(15)
													.add(9)
													.add(31)
													.add(42)
													.add(3)
													.build();
		//long count = streamBuilder.count();
		//System.out.println("Count streamBuilder: " + count);
		
		//Integer max = streamBuilder.max(Integer::compare).get();
		//System.out.println("Max streamBuilder: " + max);
		
		//Integer min = streamBuilder.min(Integer::compare).get();
		//System.out.println("Min streamBuilder: " + min);
		
		streamBuilder.sorted().limit(3).forEach(ele -> System.out.println(ele));
		sMod.sorted().limit(2).forEach(ele -> System.out.println(ele));
		
	}

}
