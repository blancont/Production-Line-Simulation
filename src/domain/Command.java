package domain;

import java.util.ArrayList;

import dataSource.Database;

public class Command {
	int controller_id;
	int coffee_machine_id;
	int orderID;
	String drinkName;
	String requestType;
	ArrayList<Condiment> options;
	SearchBehavior behavior;

	public Command(int control_id, int orderID, String drinkName, String requestType, ArrayList<Condiment> options) {
		this.controller_id = control_id;
		this.orderID = orderID;
		this.drinkName = drinkName;
		this.requestType = requestType;
		this.options = options;
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

}
