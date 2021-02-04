package domain;

public class RecipeInstruction {
	private String commandstep;
	private String object;
	
	public RecipeInstruction(String commandstep, String object) {
		this.commandstep = commandstep;
		this.object = object;
	}
	
	public String getCommandStep() {
		return commandstep;
	}
	
	public String getObject() {
		return object;
	}
	
	public void printInstruction() {
		System.out.println(commandstep + " " + object);
	}
}
