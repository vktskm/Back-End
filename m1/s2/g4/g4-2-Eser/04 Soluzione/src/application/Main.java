package application;

import entities.Customer;
import entities.Order;
import entities.Product;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
	
	public static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		
//		CUSTOMERS
		
		List <Customer> customers = new ArrayList<Customer>();
		
		Customer andrea = new Customer(123456, "Andrea", 2);
		Customer mario = new Customer(234566, "Mario", 8);
		Customer giuseppe = new Customer(123324, "Giuseppe", 2);
		Customer riccardo = new Customer(134555, "Riccardo", 2);
		
		customers.add(giuseppe);
		customers.add(mario);
		customers.add(andrea);
		customers.add(riccardo);		
		
//		PRODUCTS
		
		List <Product> products = new ArrayList<Product>();
		
		Product product1 = new Product(22222, "Motorcycle", "Vehicle", 10500.00);
		Product product2 = new Product(12345, "Car", "Vehicle", 15500.00);
		Product product3 = new Product(54321, "1984", "Books", 100.50);
		Product product4 = new Product(21342, "La Commedia", "Books", 15);
		Product product5 = new Product(43214, "Decameron", "Books", 17.90);
		Product product6 = new Product(41234, "Stroller", "Baby", 50.00);
		Product product7 = new Product(55634, "Crib", "Baby", 48.90);
		Product product8 = new Product(54322, "PlayStation", "Boys", 500.99);
		Product product9 = new Product(44114, "XBox", "Boys", 450.90);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		
//		ORDERS
		
		List <Order> orders = new ArrayList<Order>();
		
		List <Product> products2 = new ArrayList<Product>();
		products2.add(product6);
		List <Product> products3 = new ArrayList<Product>();
		products3.add(product5);
		List <Product> products4 = new ArrayList<Product>();
		products4.add(product7);
		List <Product> products5 = new ArrayList<Product>();
		products5.add(product8);
		List <Product> products6 = new ArrayList<Product>();
		products6.add(product9);
		List <Product> products7 = new ArrayList<Product>();
		products7.add(product1);
		
		
		LocalDate today = LocalDate.now();
		LocalDate delivery = today.plusDays(3);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date1 = LocalDate.parse("2021/02/05", formatter);
		LocalDate date2 = LocalDate.parse("2021/03/05", formatter);
		
		Order order1 = new Order(12345, "Disponibile", today, delivery, products2, mario);
		Order order2 = new Order(12345, "Disponibile", today, delivery, products3, andrea);
		Order order3 = new Order(12345, "Disponibile", date1, delivery, products4, riccardo);
		Order order4 = new Order(12345, "Disponibile", today, delivery, products5, andrea);
		Order order5 = new Order(12345, "Disponibile", date2, delivery, products7, andrea);
		Order order6 = new Order(12345, "Disponibile", date2, delivery, products6, giuseppe);
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		orders.add(order5);
		orders.add(order6);
		
//		LIBRI SOTTO I 100 EURO
		List<String> booksOverHundred = products.stream().filter(n -> n.getCategory().equals("Books")).filter(n -> n.getPrice() > 100).map(Product::getName).toList();
		logger.info("I libri che costano più di 100 euro sono: " + booksOverHundred);
		
		
		
//	 	ORDINI CON PRODOTTI CATEGORIA BABY
		
		List<Order> babyOrders = orders.stream()
			    .filter(order -> order.getOrderProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
		logger.info("Gli ordini che contengono prodotti 'Baby' sono: " + babyOrders.toString());
		
		
		
		
//		LISTA PRODOTTI CATEGORIA BOYS + 10% SCONTO
		
		List<String> boysOrderDiscount10 = products.stream()
			    .filter(product -> product.getCategory().equals("Boys"))
			    .map(product -> {
			    	product.setPrice(product.getPrice()*0.9);
			    	return product.getProdInfo();
			    })
			    .toList();
		
			logger.info("Gli ordini che contengono prodotti 'Boys' sono: " + boysOrderDiscount10);
		
		
		

//		LISTA PRODOTTI ORDINATI CLIENTI TIER2 TRA 1feb e 1apr 2021
			
			

			List<Product> products1 = orders.stream()
			    .filter(order -> order.getOrderCustomerName().getTier() == 2) 
			    .filter(order -> order.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) 
			    		&& order.getOrderDate().isBefore(LocalDate.parse("2021-04-01"))) 
			    .flatMap(order -> order.getOrderProducts().stream())
			    .toList();
			 
			logger.info("Prodotti ordinati da clienti di livello 2 tra 01-Feb-2021 e 01-Apr-2021: " + products1);

		
	}
	
	

}
