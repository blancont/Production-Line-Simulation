import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void test() {
		new Database();
		AppCommunicator appComm = new AppCommunicator();
		
		String test = appComm.createCommandFromInput("single-order.json", "single-con-response.json");
		assertEquals("Your coffee has been prepared with your desired options.", test);
	}
	
	@Test
	void test2() {
		new Database();
		AppCommunicator appComm = new AppCommunicator();
		
		String test = appComm.createCommandFromInput("single-order2.json", "single-con-response2.json");
		assertEquals("Your coffee order has been cancelled. Out of milk, drink cancelled", test);
	}
	
	@Test
	void test3() {
		new Database();
		AppCommunicator appComm = new AppCommunicator();

		String test = appComm.createCommandFromInput("single-order3.json", "single-con-response3.json");
		assertEquals("Your coffee order has been cancelled. Machine jammed.", test);
	}

}
