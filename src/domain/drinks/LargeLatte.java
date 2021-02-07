package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;

public class LargeLatte extends Latte {

	public LargeLatte() {
		ArrayList<RecipeInstruction> instructions = new ArrayList<RecipeInstruction>();
		instructions.add(new RecipeInstruction("steam", "milk"));
		instructions.add(new RecipeInstruction("steam", "milk"));
		instructions.add(new RecipeInstruction("add", "expresso"));
		instructions.add(new RecipeInstruction("add", "expresso"));
		instructions.add(new RecipeInstruction("mix", ""));
		instructions.add(new RecipeInstruction("top", "whipped cream"));
		
		this.name = "Large Latte";
		recipe = instructions;
	}
	
}
