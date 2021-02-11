package domain.condiments;

import domain.drinks.Drink;

public class Hazelnut extends CondimentDecorator {

	public Hazelnut(Drink drink, long qty) {
		this.drink = drink;
		this.name = "Hazelnut";
		this.qty = qty;
	}

}
