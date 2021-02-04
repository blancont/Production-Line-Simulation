package domain;
import dataSource.Database;

public class OrderHandler implements Observer {
	
	Order order;
	Command command;
	DrinkResponse response;
	
	public OrderHandler(Order order) {
		this.order = order;
	}
	
	public void sendOrder() {
		generateCommandFromOrder();
		ControllerCommunicator communicator = ControllerCommunicator.getCommunicator();
		communicator.receiveCommand(command, this);
	}
	
	public void generateCommandFromOrder() {
		// find controller to send to (by ZIP, then by type)
		Database.Controller controller = Database.findController(order.getZip(), order.hasCondiments());
		int controllerId = controller.getControllerId();
		Database.CoffeeMaker coffeeMaker = Database.findCoffeeMaker(controllerId);
		int coffeeId = coffeeMaker.getMachineId();
		int orderId = order.getOrderID();
		String drinkName = order.getDrinkName();
		String requestType = controller.getType();
		
		// at the moment, hardcoded to search by address and does not include options
		this.command = new Command(controllerId, orderId, drinkName, requestType, null);
		command.setSearchBehavior(new SelectByAddress(controller));
		command.setCoffeeMachineId();
	}

	@Override
	public void update(DrinkResponse response) {
		this.response = response;
	}

	@Override
	public int getOrderId() {
		return order.getOrderID();
	}
	
	public DrinkResponse getDrinkResponse() {
		return response;
	}
	
	public int getCoffeeId() {
		return command.getCoffeeId();
	}
}
