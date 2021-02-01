import java.io.File;
import java.util.ArrayList;

/* The idea here is to fill the database before each test case by calling
 * the set methods. It might be best to fill the database once (using the
 * example instance in the milestone document) then running every test case
 * with that database.
 * 
 * TODO: add all set methods and populate database in testing class!
 */

public final class Database {
	private static ArrayList<CoffeeMaker> coffeeMakers;
	private static File con_responseJSON;
	private static ArrayList<ControllerCommunicator> controllers;
	
	public Database () {
		controllers = new ArrayList<ControllerCommunicator>();
		controllers.add(new ControllerCommunicator(1, "Simple", "200 N. Main", 47803));
		controllers.add(new ControllerCommunicator(2, "Advanced", "200 N. Main", 47803));
		controllers.add(new ControllerCommunicator(3, "Simple", "3 S. Walnut", 60601));
	}

	public static void setCoffeeMakers(ArrayList<String[]> coffeeMakers) {
		for (String[] info : coffeeMakers) {
			coffeeMakers.add(new String[] { info[0], info[1], info[2] });
		}
	}

	class CoffeeMaker {
		int machineID;
		int controller;
		String description;

		public CoffeeMaker(int machineID, int controller, String description) {
			this.machineID = machineID;
			this.controller = controller;
			this.description = description;
		}
	}

	public static void setControllerResponse(File JSON) {
		con_responseJSON = JSON;
	}

	public static File getControllerResponse() {
		return con_responseJSON;
	}

	public static ArrayList<ControllerCommunicator> getControllerComms() {
		return controllers;
	}
}
