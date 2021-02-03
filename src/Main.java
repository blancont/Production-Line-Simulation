import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		new Database();
		AppCommunicator appComm = new AppCommunicator();
		UserResponse response = appComm.receiveJSON("single-order.json");
		response.displayResponse();
	}
}
