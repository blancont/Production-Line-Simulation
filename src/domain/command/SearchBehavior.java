package domain.command;
import dataSource.Database.CoffeeMaker;

public interface SearchBehavior {
	public CoffeeMaker findCoffeeMachine();
}
