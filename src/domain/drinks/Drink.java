package domain.drinks;

import java.util.ArrayList;

import domain.RecipeInstruction;
import domain.condiments.Condiment;

public abstract class Drink {
	protected String name;
	protected ArrayList<RecipeInstruction> recipe;
	protected String description;
	
	public ArrayList<Condiment> getOptions(){
		return new ArrayList<Condiment>();
	}
	
	public ArrayList<RecipeInstruction> getRecipe(){
		return recipe;
	}
}
