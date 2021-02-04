package domain.command;
import dataSource.Database;

public class SelectByMachineType implements SearchBehavior {
	
	Database.Controller controller;
	
	public SelectByMachineType(Database.Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public Database.CoffeeMaker findCoffeeMachine() {
		return Database.findCoffeeMakerByMachineType(controller);
	}
}
