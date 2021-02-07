package domain.command;

import java.util.ArrayList;

import dataSource.Database;
import domain.RecipeInstruction;
import domain.condiments.Condiment;

public class Command {
	public int controller_id;
	public int coffee_machine_id;
	public int orderID;
	public String drinkName;
	public String requestType;
	public ArrayList<Condiment> options;
	public SearchBehavior behavior;
	public ArrayList<RecipeInstruction> recipe;

	public Command(int control_id, int orderID, String drinkName, String requestType, ArrayList<Condiment> options,
			ArrayList<RecipeInstruction> recipe) {
		this.controller_id = control_id;
		this.orderID = orderID;
		this.drinkName = drinkName;
		this.requestType = requestType;
		this.options = options;
		this.recipe = recipe;
	}

	public int getCoffeeId() {
		return coffee_machine_id;
	}

	public void setSearchBehavior(SearchBehavior behavior) {
		this.behavior = behavior;
	}

	public void setCoffeeMachineId() {
		Database.CoffeeMaker coffeeMaker = behavior.findCoffeeMachine();
		this.coffee_machine_id = coffeeMaker.getMachineId();
	}
	
	public void printCommandContents() {
		System.out.println("[Command] -- COMMAND CONTENTS --");
		System.out.println("controller_id = " + controller_id);
		System.out.println("coffee_machine_id = " + coffee_machine_id);
		System.out.println("orderID = " + orderID);
		System.out.println("DrinkName = " + drinkName);
		System.out.println("RequestType = " + requestType);
		for (Condiment c : options) {
			System.out.println("Options: " + c.getName() + " with qty " + c.getQty());
		}
		for (RecipeInstruction ri : recipe) {
			System.out.print("Recipe: ");
			ri.printInstruction();
		}
		System.out.println();
	}

}
