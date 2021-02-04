package domain.condiments;

import domain.drinks.Drink;

public class Nutrasweet extends CondimentDecorator {

	public Nutrasweet(Drink drink) {
		this.drink = drink;
		this.name = "nutrasweet";
	}

}
