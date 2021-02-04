package domain.condiments;

import domain.drinks.Drink;

public class Hazelnut extends CondimentDecorator {

	public Hazelnut(Drink drink) {
		this.drink = drink;
		this.name = "hazelnut";
	}

}
