import java.util.ArrayList;

public class ControllerCommunicator implements Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private int assocId;
	private String type;
	private String streetAddress;
	private int zipCode;
	private Command command;
	
	public ControllerCommunicator(int assocId, String type, String streetAddress, int zipCode) {
		this.assocId = assocId;
		this.type = type;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	
	public int getAssocId() {
		return assocId;
	}
	
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if(index >= 0) {
			observers.remove(index);
		}
	}

	@Override
	public String notifyObservers(DrinkResponse response) {
		for(Observer o : observers) {
			if(response.getOrderId() == o.getOrderId()) {
				return o.update(response);
			}
		}
		return "Order not found";
	}

	public String takeCommand(Command command, OrderHandler handler, String responseFilename) {
		this.command = command;
		registerObserver(handler);
		
		// wait for machine to return response
		return takeDrinkResponse(responseFilename);
	}
	
	public String takeDrinkResponse(String filename) {
		// drink response comes from machine
		DrinkResponse response = DataReader.parseControllerResponse(filename);
		return notifyObservers(response);
	}

}
