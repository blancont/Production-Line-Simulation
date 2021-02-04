package domain.command;
import dataSource.Database;

public class SelectByAddress implements SearchBehavior {
	
	Database.Controller controller;
	
	public SelectByAddress(Database.Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public Database.CoffeeMaker findCoffeeMachine() {
		return Database.findCoffeeMakerByAddress(controller);
	}
}
