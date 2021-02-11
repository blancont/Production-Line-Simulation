package domain.condiments;

import java.util.ArrayList;

import domain.RecipeInstruction;
import domain.drinks.Drink;

public abstract class CondimentDecorator extends Drink {

	protected Drink drink;
	long qty;
	
	@Override
	public ArrayList<Condiment> getOptions() {
		ArrayList<Condiment> condiments = drink.getOptions();
		condiments.add(new Condiment(name, qty));
		return condiments;
	}
	
	public ArrayList<RecipeInstruction> getRecipe(){
		return drink.getRecipe();
	}
}
