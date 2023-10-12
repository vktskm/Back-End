package com.epicode.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainProject {
	
	static List<Product> listaProdotti = new ArrayList<Product>();
	static List<Order> listaOrdini = new ArrayList<Order>();

	public static void main(String[] args) {

		Product p1 = new Product(1l, "Il Signore degli Anelli", "Books", 25.6);
		Product p2 = new Product(2l, "Ciuccio", "Baby", 5.0);
		Product p3 = new Product(3l, "T-shirt", "Boys", 12.0);
		
		listaProdotti.add(p1);
		listaProdotti.add(p2);
		listaProdotti.add(p3);
		
		Customer c1 = new Customer(1l, "Mario Rossi", 1);
		Customer c2 = new Customer(2l, "Giuseppe Verdi", 2);
		
		Order o1 = new Order(1l, "Evaso", LocalDate.of(2021, 1, 25), LocalDate.of(2021, 01, 30), Arrays.asList(p1, p3), c1);
		Order o2 = new Order(2l, "Consegnato", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 02, 06), Arrays.asList(p1, p2, p3), c2);
		Order o3 = new Order(3l, "Spedito", LocalDate.of(2021, 5, 9), LocalDate.of(2021, 05, 12), Arrays.asList(p2, p3), c1);
		Order o4 = new Order(4l, "Consegnato", LocalDate.of(2021, 6, 15), LocalDate.of(2021, 06, 20), Arrays.asList(p1, p2), c2);
		
		listaOrdini.add(o1);
		listaOrdini.add(o2);
		listaOrdini.add(o3);
		listaOrdini.add(o4);
		
		//listaProdotti.forEach(p -> System.out.println(p));
		//listaOrdini.forEach(o -> System.out.println(o));
		
		//List<Product> listaBooks20 = esercizio1(listaProdotti);
		//listaBooks20.forEach(p -> System.out.println(p));
		
		//List<Order> listaOrdersBaby = esercizio2(listaOrdini);
		//listaOrdersBaby.forEach(o -> System.out.println(o));
		
		//List<Product> listaBoys10 = esercizio3(listaProdotti);
		//listaBoys10.forEach(p -> System.out.println(p));
		
		//List<Product> listaTier2 = esercizio4(listaOrdini);
		//listaTier2.forEach(p -> System.out.println(p));

	}
	
	public static List<Product> esercizio1(List<Product> allProducts) {
		//Esercizio #1
		//Ottenere una lista di prodotti che appartengono alla 
		//categoria «Books» ed hanno un prezzo > 100
		
		return allProducts
					.stream()
					.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
					.filter(p -> p.getPrice() > 20)
					.collect(Collectors.toList());
	}
	
	public static List<Order> esercizio2(List<Order> allOrders) {
		//Esercizio #2
		//Ottenere una lista di ordini con prodotti che appartengono 
		//alla categoria «Baby»
		return allOrders
			.stream()
			.filter(o -> 
				o.getProducts()
					.stream()
					.anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
			).collect(Collectors.toList());
	}

	public static List<Product> esercizio3(List<Product> allProducts) {
		//Esercizio #3
		//Ottenere una lista di prodotti che appartengono alla 
		//categoria «Boys» ed applicare 10% di sconto al loro prezzo
		return allProducts
					.stream()
					.filter(p -> p.getCategory().equalsIgnoreCase("Boys"))
					.map(p -> {
						p.setPrice(p.getPrice() * 0.9);
						return p;
					})
					.collect(Collectors.toList());
	}

	public static List<Product> esercizio4(List<Order> allOrders) {
		//Esercizio #4
		//Ottenere una lista di prodotti ordinati da clienti di 
		//livello (tier) 2 tra l’01-Feb-2021 e l’01-Apr-2021
		return allOrders
					.stream()
					.filter(o -> o.getCustomer().getTier() == 2)
					.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
					.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
					.flatMap(o -> o.getProducts().stream())
					.distinct()
					.collect(Collectors.toList());
	}

}
