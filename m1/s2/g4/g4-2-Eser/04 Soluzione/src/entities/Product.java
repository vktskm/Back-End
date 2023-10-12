package entities;

public class Product {
	
	private long id;
	private String name;
	private String category;
	private Double price;
	
	public Product(long id, String name, String category, double price) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public String getProdInfo() {
		
		return ( "ID: " + id + " Product Name: " + name + " Category: " + category + " Price: " + price);
	}
	
	public double getPrice() {
		
		return price;
	}
	
	public double setPrice(Double newPrice) {
		return this.price = newPrice;
		
	}
	public String getCategory() {
		return category;
	}
	public String getName() {
		return ("Product name: " + name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}