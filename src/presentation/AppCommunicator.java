package presentation;
import dataSource.*;
import domain.*;

public class AppCommunicator {

	Command command;
	OrderHandler handler;
	/*
	 * in practice, perhaps this should be a list of handlers, if the system wishes
	 * to handle more than one order at a time
	 */

	public UserResponse receiveJSON(String filename) {
		Order order = JSONConverter.parseOrder(filename);
		this.handler = new OrderHandler(order);
		handler.sendOrder();
		/*
		 * in this contained system, the response should come instantaneously, but in
		 * practice AppCommunicator should probably continue to query OrderHandler until
		 * a response is received. should AppComm be an observer to OrderHandler? will
		 * ask Dr. Zhang later
		 */
		DrinkResponse controllerResponse = handler.getDrinkResponse();
		return generateAppResponseFrom(controllerResponse, order);
	}

	public UserResponse generateAppResponseFrom(DrinkResponse controllerResponse, Order order) {
		int orderId = order.getOrderID();
		int coffeeId = handler.getCoffeeId();
		int status = controllerResponse.getStatus();
		String statusMessage = "Your coffee has been prepared with your desired options.";
		String errorMessage = controllerResponse.getErrorDesc();
		
		// if unsuccessful
		if (status == 1) {
			statusMessage = "Your coffee order has been cancelled.";
			return new UserResponse(orderId, coffeeId, status, statusMessage, errorMessage);
		}
		return new UserResponse(orderId, coffeeId, status, statusMessage, errorMessage);
	}
}