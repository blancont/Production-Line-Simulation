//public class OrderHandler implements Observer {
//	
//	private Command command;
//	private ControllerCommunicator controller;
//	private AppCommunicator appCommunicator;
//	
//	public OrderHandler(Command command, ControllerCommunicator controller, AppCommunicator appCommunicator) {
//		this.command = command;
//		this.controller = controller;
//		this.appCommunicator = appCommunicator;
//	}
//
//	@Override
//	public String update(DrinkResponse response) {
//		controller.removeObserver(this);
//		return appCommunicator.takeDrinkResponse(response);
//	}
//
//	@Override
//	public int getOrderId() {
//		return command.getOrderId();
//	}
//}

public class OrderHandler implements Observer {
	
	Order order;
	Command command;
	DrinkResponse response;
	
	public OrderHandler(Order order) {
		this.order = order;
	}
	
	public void sendOrder() {
		this.command = generateCommandFromOrder();
		ControllerCommunicator communicator = ControllerCommunicator.getCommunicator();
		communicator.receiveCommand(command, this);
	}
	
	public Command generateCommandFromOrder() {
		// find controller to send to (by ZIP, then by type)
		Database.Controller controller = Database.findController(order.getZip(), order.hasCondiments());
		int controllerId = controller.controllerId;
		Database.CoffeeMaker coffeeMaker = Database.findCoffeeMaker(controllerId);
		int coffeeId = coffeeMaker.machineId;
		int orderId = order.getOrderID();
		String drinkName = order.getDrinkName();
		String requestType = controller.type;
		return new Command(controllerId, coffeeId, orderId, drinkName, requestType);
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
