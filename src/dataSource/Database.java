package dataSource;
import java.io.File;
import java.util.ArrayList;

/* The idea here is to fill the database before each test case by calling
 * the set methods. It might be best to fill the database once (using the
 * example instance in the milestone document) then running every test case
 * with that database.
 * 
 * TODO: add all set methods and populate database in testing class!
 */

public class Database {
	private static ArrayList<Controller> controllers = new ArrayList<Controller>();
	private static ArrayList<CoffeeMaker> coffeeMakers = new ArrayList<CoffeeMaker>();
	private static String controller_response_filename;

	public void setControllers(ArrayList<String[]> controllerList) {
		for (String[] info : controllerList) {
			Controller controller = new Controller(Integer.parseInt(info[0]),
					info[1], info[2], info[3]);
			controllers.add(controller);
		}
	}
	
	public void setCoffeeMakers(ArrayList<String[]> coffeeMakerList) {
		for (String[] info : coffeeMakerList) {
			CoffeeMaker coffeeMaker = new CoffeeMaker(Integer.parseInt(info[0]),
					Integer.parseInt(info[1]), info[2]);
			coffeeMakers.add(coffeeMaker);
		}
	}
	
	public static Controller findController(int zip_code, boolean hasCondiments) {
		for (Controller controller : controllers) {
			if (Integer.parseInt(controller.zip_code) == zip_code) {
				if (hasCondiments) {
					if (!controller.type.equals("Simple")) {
						
						return controller;
					}
				} else {					
					return controller;
				}
			}
		}
		return null;
	}
	
	// currently only returns first coffee maker with valid id
	public static CoffeeMaker findCoffeeMaker(int controller_id) {
		for (CoffeeMaker coffeeMaker : coffeeMakers) {
			if (coffeeMaker.controller == controller_id) {
				return coffeeMaker;
			}
		}
		return null;
	}

	public class CoffeeMaker {
		int machineId;
		int controller;
		String description;

		public CoffeeMaker(int machineID, int controller, String description) {
			this.machineId = machineID;
			this.controller = controller;
			this.description = description;
		}
		
		public int getMachineId() { return machineId; }
		
	}
	
	public class Controller {
		int controllerId;
		String type;
		String street_address;
		String zip_code;
		
		public Controller(int controllerId, String type, String street_address, String zip_code) {
			this.controllerId = controllerId;
			this.type = type;
			this.street_address = street_address;
			this.zip_code = zip_code;
		}
		
		public int getControllerId() { return controllerId; }
		public String getType() { return type; }
	}

	public void setControllerResponse(String filename) {
		controller_response_filename = filename;
	}

	public static String getControllerResponseFilename() {
		return controller_response_filename;
	}

}
