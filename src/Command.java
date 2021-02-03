
public class Command {
	int controller_id;
	int coffee_machine_id;
	int orderID;
	String drinkName;
	String requestType;
	
	public Command(int control_id, int coffee_id, int orderID, String drinkName, String requestType) {
		this.controller_id = control_id;
		this.coffee_machine_id = coffee_id;
		this.orderID = orderID;
		this.drinkName = drinkName;
		this.requestType = requestType;
	}
	
	public int getCoffeeId() {
		return coffee_machine_id;
	}
	
}
