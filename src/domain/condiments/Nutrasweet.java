package domain.condiments;

import domain.drinks.Drink;

public class Nutrasweet extends CondimentDecorator {

	public Nutrasweet(Drink drink, long qty) {
		this.drink = drink;
		this.name = "Nutrasweet";
		this.qty = qty;
	}

}
