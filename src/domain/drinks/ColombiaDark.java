package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class ColombiaDark extends Drink {

	public ColombiaDark() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		
		this.name = "Colombia Dark";
		this.description = "Stronger roast with Colombian beans";
		this.recipe = instructions;
	}

}
