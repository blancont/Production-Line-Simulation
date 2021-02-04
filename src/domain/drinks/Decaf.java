package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class Decaf extends Drink {

	public Decaf() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		
		this.name = "Decaf";
		this.description = "Regular decaffeinated coffee";
		this.recipe = instructions;
	}

}
