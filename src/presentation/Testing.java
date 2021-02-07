package presentation;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import dataSource.Database;
import dataSource.Database.Controller;
import domain.ControllerCommunicator;
import domain.RecipeInstruction;
import domain.UserResponse;
import domain.command.Command;
import domain.condiments.Condiment;

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
	
	
	@Test
	void testBasicOrder() {
		setUpDatabase();
		AppCommunicator appComm = new AppCommunicator();
		appComm.receiveJSON("single-order2.json");
		
		// VERIFY COMMAND
		Command command = Database.getCommandSent();
		assertEquals(2, command.orderID);
		assertEquals("Expresso", command.drinkName);
		assertEquals(0, command.options.size());
		
		// respond to command
		ControllerCommunicator controlComm = ControllerCommunicator.getCommunicator();
		controlComm.receiveCommand("single-con-response2.json");
		UserResponse response = appComm.generateAppResponse();
		
		// VERIFY USER RESPONSE
		response.printContents();
		assertEquals(2, response.orderID);
		assertEquals(1, response.status);
		assertEquals("Your coffee order has been cancelled.", response.statusMessage);
		assertEquals("Out of milk, drink cancelled", response.errorMessage);
	}
	
	@Test
	void testOrderWithOptions() {
		testOptions1();
		testOptions2();
	}
	
	@Test
	void testOrderWithRecipe() {
		testRecipe();
		testRecipe2();
	}
	
	@Test
	void testOptions1() {
		// set up
		setUpDatabase();
		AppCommunicator appComm = new AppCommunicator();
		// send command
		appComm.receiveJSON("single-order.json");

		// VERIFY COMMAND
		Command command = Database.getCommandSent();
		assertEquals(1, command.orderID);
		assertEquals("Americano", command.drinkName);
		assertNotEquals("Simple", command.requestType);
		int condsToVerify = 2;
		for (Condiment c : command.options) {
			switch (c.getName()) {
			case "Sugar":
				if (c.getQty() == 1)
					condsToVerify--;
			case "Cream":
				if (c.getQty() == 2)
					condsToVerify--;
			}
		}
		assertEquals(0, condsToVerify);

		// respond to command
		ControllerCommunicator controlComm = ControllerCommunicator.getCommunicator();
		controlComm.receiveCommand("single-con-response.json");
		UserResponse response = appComm.generateAppResponse();

		// VERIFY USER RESPONSE
		response.printContents();
		assertEquals(1, response.orderID);
		assertEquals(0, response.status);
		assertEquals("Your coffee has been prepared with your desired options.", response.statusMessage);
		assertNull(response.errorMessage);
	}
	
	@Test
	void testOptions2() {
		setUpDatabase();
		AppCommunicator appComm = new AppCommunicator();
		appComm.receiveJSON("single-order3.json");
		
		// VERIFY COMMAND
		Command command = Database.getCommandSent();
		assertEquals(3, command.orderID);
		assertEquals("Pumpkin Spice", command.drinkName);
		assertNotEquals("Simple", command.requestType);
		int condsToVerify = 1;
		for (Condiment c : command.options) {
			switch (c.getName()) {
			case "Cream":
				if (c.getQty() == 1)
					condsToVerify--;
			}
		}
		assertEquals(0, condsToVerify);
		
		// respond to command
		ControllerCommunicator controlComm = ControllerCommunicator.getCommunicator();
		controlComm.receiveCommand("single-con-response3.json");
		UserResponse response = appComm.generateAppResponse();
		
		// VERIFY USER RESPONSE
		response.printContents();
		assertEquals(3, response.orderID);
		assertEquals(1, response.status);
		assertEquals("Your coffee order has been cancelled.", response.statusMessage);
		assertEquals("Machine jammed.", response.errorMessage);
	}
	
	@Test
	void testRecipe() {
		setUpDatabase();
		AppCommunicator appComm = new AppCommunicator();
		appComm.receiveJSON("testing/single-order4.json");
		
		Command command = Database.getCommandSent();
		assertEquals(4, command.orderID);
		assertEquals("Large Latte", command.drinkName);
		assertEquals("Programmable", command.requestType);
		
		// verify condiments
		int condsToVerify = 1;
		for (Condiment c : command.options) {
			switch (c.getName()) {
			case "Hazelnut":
				if (c.getQty() == 2)
					condsToVerify--;
			}
		}
		assertEquals(0, condsToVerify);
		
		// verify recipe
		int stepsToVerify = 6;
		for (RecipeInstruction ri : command.recipe) {
			switch (ri.getCommandStep()) {
			case "steam":
				if (ri.getObject().equals("milk"))
					stepsToVerify--;
			case "add":
				if (ri.getObject().equals("expresso"))
					stepsToVerify--;
			case "mix":
				if (ri.getObject().equals(""))
					stepsToVerify--;
			case "top":
				if (ri.getObject().equals("whipped cream"))
					stepsToVerify--;
			}
		}
		assertEquals(0, stepsToVerify);
	}
	
	@Test
	void testRecipe2() {
		setUpDatabase();
		AppCommunicator appComm = new AppCommunicator();
		appComm.receiveJSON("testing/single-order5.json");
		
		Command command = Database.getCommandSent();
		assertEquals(5, command.orderID);
		assertEquals("Regular Latte", command.drinkName);
		assertEquals("Programmable", command.requestType);
		
		// verify condiments
		int condsToVerify = 1;
		for (Condiment c : command.options) {
			switch (c.getName()) {
			case "Hazelnut":
				if (c.getQty() == 2)
					condsToVerify--;
			}
		}
		assertEquals(0, condsToVerify);
		
		// verify recipe
		int stepsToVerify = 3;
		for (RecipeInstruction ri : command.recipe) {
			switch (ri.getCommandStep()) {
			case "steam":
				if (ri.getObject().equals("milk"))
					stepsToVerify--;
			case "add":
				if (ri.getObject().equals("expresso"))
					stepsToVerify--;
			case "top":
				if (ri.getObject().equals("whipped cream"))
					stepsToVerify--;
			}
		}
		assertEquals(0, stepsToVerify);
	}
	
	@Test
	void testRecipe3() {
		setUpDatabase();
		AppCommunicator appComm = new AppCommunicator();
		appComm.receiveJSON("testing/single-order6.json");
		
		Command command = Database.getCommandSent();
		assertEquals(6, command.orderID);
		assertEquals("Pumpkin Spice", command.drinkName);
		assertEquals("Programmable", command.requestType);
		
		// verify condiments
		int condsToVerify = 1;
		for (Condiment c : command.options) {
			switch (c.getName()) {
			case "Sugar":
				if (c.getQty() == 2)
					condsToVerify--;
			}
		}
		assertEquals(0, condsToVerify);
		
		// verify recipe
		int stepsToVerify = 4;
		for (RecipeInstruction ri : command.recipe) {
			switch (ri.getCommandStep()) {
			case "add":
				if (ri.getObject().equals("coffee"))
					stepsToVerify--;
				if (ri.getObject().equals("pumpkin spice"))
					stepsToVerify--;
			case "mix":
				if (ri.getObject().equals(""))
					stepsToVerify--;
			case "top":
				if (ri.getObject().equals("nutmeg"))
					stepsToVerify--;
			}
		}
		assertEquals(0, stepsToVerify);
	}

}
