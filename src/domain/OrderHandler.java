package domain;
import java.util.ArrayList;

import dataSource.Database;
import domain.command.Command;
import domain.command.SelectByAddress;
import domain.condiments.Condiment;
import domain.condiments.*;
import domain.drinks.Drink;

public class OrderHandler implements Observer {
	
	Order order;
	Command command;
	DrinkResponse response;
	DrinkFactory factory;
	
	public OrderHandler(Order order) {
		this.order = order;
		order.printOrderContents();
		factory = new CoffeeFactory();
	}
	
	public void sendOrder() {
		buildDrink();
		generateCommandFromOrder();
		ControllerCommunicator communicator = ControllerCommunicator.getCommunicator();
		communicator.receiveCommand(command, this);
	}
	
	public void buildDrink() {
		Drink drink = factory.makeDrink(order.getDrinkName());
		ArrayList<Condiment> condiments = order.getCondiments();
		for (Condiment condiment : condiments) {
			String condName = condiment.getName();
			switch (condName) {
			case "Sugar":
				drink = new Sugar(drink);
			case "Nutrasweet":
				drink = new Nutrasweet(drink);
			case "Hazelnut":
				drink = new Hazelnut(drink);
			case "Cream":
				drink = new Cream(drink);
			}
		}
		order.setDrink(drink);
	}
		
	public void generateCommandFromOrder() {
		// find controller to send to (by ZIP, then by type)
		Database.Controller controller = Database.findController(order.getZip(), order.hasCondiments());
		
		// defining other attributes
		int controllerId = controller.getControllerId();
		int orderId = order.getOrderID();
		String drinkName = order.getDrinkName();
		String requestType = controller.getType();
		Drink drink = order.getDrink();
		ArrayList<Condiment> condiments = order.getCondiments();
		ArrayList<RecipeInstruction> recipe = drink.getRecipe();
		
		// at the moment, hardcoded to search by address and does not include options
		this.command = new Command(controllerId, orderId, drinkName, requestType, condiments, recipe);
		command.setSearchBehavior(new SelectByAddress(controller));
		command.setCoffeeMachineId();
	}

	@Override
	public void update(DrinkResponse response) {
		this.response = response;
	}

	@Override
	public int getOrderId() {
		return order.getOrderID();
	}
	
	public DrinkResponse getDrinkResponse() {
		return response;
	}
	
	public int getCoffeeId() {
		return command.getCoffeeId();
	}
}