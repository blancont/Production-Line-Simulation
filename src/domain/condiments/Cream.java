package domain.condiments;

import java.util.ArrayList;

import domain.drinks.Drink;

public class Cream extends CondimentDecorator {

	public Cream(Drink drink) {
		this.drink = drink;
		this.name = "cream";
	}
}
