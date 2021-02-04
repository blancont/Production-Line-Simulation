package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class Expresso extends Drink{

	public Expresso() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		
		this.name = "Expresso";
		this.description = "Coffee concentrated";
		this.recipe = instructions;
	}

}
