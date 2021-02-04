package domain;
import java.util.ArrayList;

public class Order {
	private int orderID;
	private String street;
	private int zip;
	private String drink;
	private ArrayList<Condiment> condiments;
	
	public Order(int orderID, String street, int zip, String drink) {
		this.orderID = orderID;
		this.street = street;
		this.zip = zip;
		this.drink = drink;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public String toString() {
		return orderID + ", " + street;
	}
	
	public String getDrinkName() {
		return drink;
	}
	
	public int getZip() {
		return zip;
	}
	
	public boolean hasCondiments() {
		return this.condiments != null;
	}
}