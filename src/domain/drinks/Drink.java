package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;
import domain.condiments.Condiment;

public abstract class Drink {
	protected String name;
	protected ArrayList<RecipeInstruction> recipe = new ArrayList<RecipeInstruction>();
	protected String description;
	
	public ArrayList<Condiment> getOptions(){
		return new ArrayList<Condiment>();
	}
	
	public ArrayList<RecipeInstruction> getRecipe(){
		return recipe;
	}
	
	public boolean hasRecipe() {
		return !recipe.isEmpty();
	}
}
