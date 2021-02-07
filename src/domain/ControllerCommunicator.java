package domain;
import java.util.ArrayList;

import dataSource.Database;
import dataSource.JSONConverter;
import domain.command.Command;

public class ControllerCommunicator implements Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private static ControllerCommunicator communicator;

	private ControllerCommunicator() {
	}

	public void sendCommand(Command command, Observer handler) {
		command.printCommandContents();
		registerObserver(handler);
		sendToController(command);
	}
	
	public void receiveCommand(String responseFilename) {
		// this code executes once the controller has responded to our command
		// for our purposes, this response is hardcoded
		DrinkResponse response = JSONConverter.parseControllerResponse(responseFilename);
		notifyObservers(response);
	}

	private void sendToController(Command command) {
		/*
		 * normally there would be code here to make sure the command is sent to the
		 * correct controller by checking the command's controller_id, but we don't need
		 * to code explicit interactions with objects outside the system for our
		 * purposes
		 */
		
		// send to Database class to verify correctness
		Database.setCommandSent(command);
	}

	public static ControllerCommunicator getCommunicator() {
		if (communicator == null) {
			communicator = new ControllerCommunicator();
		}
		return communicator;
	}

	// SUBJECT METHODS
	@Override
	public void registerObserver(Observer o) { observers.add(o); }

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if (index >= 0) { observers.remove(index); }
	}

	@Override
	public void notifyObservers(DrinkResponse response) {
		ArrayList<Observer> removals = new ArrayList<Observer>();
		for (Observer o : observers) {
			if (response.getOrderId() == o.getOrderId()) {
				o.update(response);
				removals.add(o);
			}
		}
		for (Observer o : removals) {
			removeObserver(o);
		}
	}
}
