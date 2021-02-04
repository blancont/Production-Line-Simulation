package domain;

import domain.drinks.Drink;

public interface DrinkFactory {

	Drink makeDrink(String drinkName);

}
