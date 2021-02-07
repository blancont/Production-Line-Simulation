package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class PumpkinSpice extends Drink {

	public PumpkinSpice() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		instructions.add(new RecipeInstruction("add", "coffee"));
		instructions.add(new RecipeInstruction("add", "pumpkin spice"));
		instructions.add(new RecipeInstruction("mix", ""));
		instructions.add(new RecipeInstruction("top", "nutmeg"));
		
		this.name = "Pumpkin Spice";
		this.description = "Seasonal drink w/ Pumpkin";
		this.recipe = instructions;
	}

}
