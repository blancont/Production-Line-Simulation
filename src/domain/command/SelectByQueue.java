package domain.command;
import dataSource.Database;

public class SelectByQueue implements SearchBehavior {
	
	Database.Controller controller;
	
	public SelectByQueue(Database.Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public Database.CoffeeMaker findCoffeeMachine() {
		return Database.findCoffeeMakerByQueue(controller);
	}
}
