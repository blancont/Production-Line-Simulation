
public class OrderHandler implements Observer {
	
	private Command command;
	private ControllerCommunicator controller;
	private AppCommunicator appCommunicator;
	
	public OrderHandler(Command command, ControllerCommunicator controller, AppCommunicator appCommunicator) {
		this.command = command;
		this.controller = controller;
		this.appCommunicator = appCommunicator;
	}

	@Override
	public String update(DrinkResponse response) {
		controller.removeObserver(this);
		return appCommunicator.takeDrinkResponse(response);
	}

	@Override
	public int getOrderId() {
		return command.getOrderId();
	}
}
