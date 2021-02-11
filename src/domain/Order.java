package domain;
import java.util.ArrayList;

import domain.condiments.Condiment;
import domain.drinks.Drink;

public class Order {
	private int orderID;
	private String street;
	private int zip;
	private Drink drink;
	private String drinkName;
	private ArrayList<Condiment> condiments;
	
	public Order(int orderID, String street, String drinkName, int zip, ArrayList<Condiment> condiments) {
		this.orderID = orderID;
		this.street = street;
		this.zip = zip;
		this.condiments = condiments;
		this.drinkName = drinkName;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public int getZip() {
		return zip;
	}
	
	public String getDrinkName() {
		return drinkName;
	}
	
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	
	public Drink getDrink() {
		return drink;
	}
	
	public ArrayList<Condiment> getCondiments(){
		return condiments;
	}
	
	public boolean hasCondiments() {
		return this.condiments != null;
	}
	
	public boolean hasRecipe() {
		return drink.hasRecipe();
	}
	
	public void printOrderContents() {
		System.out.println("[Order] -- ORDER CONTENTS --");
		System.out.println("order_id = " + orderID);
		System.out.println("street = " + street);
		System.out.println("zip = " + zip);
		System.out.println("drink = " + drinkName);
		for (Condiment c : condiments) {
			System.out.println("Options: " + c.name + " with qty " + c.qty);
		}
		System.out.println();
	}
}