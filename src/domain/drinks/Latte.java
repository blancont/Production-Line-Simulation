package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class Latte extends Drink {
	
	public Latte() {
		ArrayList<RecipeInstruction> recipe = new ArrayList<RecipeInstruction>();
		recipe.add(new RecipeInstruction("steam", "milk"));
		recipe.add(new RecipeInstruction("add", "expresso"));
		recipe.add(new RecipeInstruction("top", "whipped cream"));
		
		this.name = "Latte";
		this.description = "Coffee drink with milk and whipped cream";
		this.recipe = recipe;
	}

}
