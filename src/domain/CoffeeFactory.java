package domain;

import domain.drinks.Americano;
import domain.drinks.ColombiaDark;
import domain.drinks.Decaf;
import domain.drinks.Drink;
import domain.drinks.Expresso;
import domain.drinks.Latte;
import domain.drinks.PumpkinSpice;

public class CoffeeFactory implements DrinkFactory{

	@Override
	public Drink makeDrink(String drinkName) {
		if(drinkName.equals("Americano")) {
			return new Americano();
		} else if(drinkName.equals("Pumpkin Spice")) {
			return new PumpkinSpice();
		} else if(drinkName.equals("Latte")) {
			return new Latte();
		} else if(drinkName.equals("Expresso")) {
			return new Expresso();
		} else if(drinkName.equals("Colombia Dark")) {
			return new ColombiaDark();
		} else if(drinkName.equals("Decaf")) {
			return new Decaf();
		}
		return null;
	}

}
