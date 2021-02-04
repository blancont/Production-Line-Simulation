package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class Americano extends Drink {
	public Americano() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		
		this.name = "Americano";
		this.description = "Regular caffeinated coffee";
		this.recipe = instructions;
	}
}
