import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Testing {
	
	Database db = new Database();
	
	void setUpDatabase() {
		ArrayList<String[]> controllers = new ArrayList<String[]>();
		controllers.add(new String[] {"1", "Simple", "200 N. Main", "47803"});
		controllers.add(new String[] {"1", "Automated", "200 N. Main", "47803"});
		controllers.add(new String[] {"1", "Programmable", "200 N. Main", "47803"});
		controllers.add(new String[] {"2", "Simple", "3 S. Walnut", "60601"});
		controllers.add(new String[] {"2", "Programmable", "3 S. Walnut", "60601"});
		
		ArrayList<String[]> coffeeMakers = new ArrayList<String[]>();
		coffeeMakers.add(new String[] {"1", "1", "Automated Italian"});
		coffeeMakers.add(new String[] {"2", "1", "Manual expresso"});
		coffeeMakers.add(new String[] {"2", "2", "Manual expresso"});
		coffeeMakers.add(new String[] {"3", "1", "Programmable"});
		coffeeMakers.add(new String[] {"3", "2", "Programmable"});
		
		
		db.setCoffeeMakers(coffeeMakers);
		db.setControllers(controllers);
	}
	
	void setControllerResponse(String filename) {
		db.setControllerResponse(filename);
	}
	
	@Test
	void test() {
		setUpDatabase();
		setControllerResponse("single-con-response.json");
		AppCommunicator appComm = new AppCommunicator();
		UserResponse response = appComm.receiveJSON("single-order.json");
		response.displayResponse();
	}
	
	@Test
	void test2() {
		setUpDatabase();
		setControllerResponse("single-con-response2.json");
		AppCommunicator appComm = new AppCommunicator();
		UserResponse response = appComm.receiveJSON("single-order2.json");
		response.displayResponse();
	}
	
	@Test
	void test3() {
		setUpDatabase();
		setControllerResponse("single-con-response3.json");
		AppCommunicator appComm = new AppCommunicator();
		UserResponse response = appComm.receiveJSON("single-order3.json");
		response.displayResponse();
	}

}
