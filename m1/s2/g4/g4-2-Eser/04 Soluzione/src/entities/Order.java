package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Product> products;
	private Customer customer;
	
	public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer){
		
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}
	
	public List<Product> getOrderProducts() {
		return products;
	}
	
	public Customer getOrderCustomerName() {
		return customer;
	}
	
	public long getOrderID() {
		return id;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	@Override
	public String toString() {
	    return "Order " + id + " - Customer: " + customer.getName() + " - Products: " + products.toString();
	}

}