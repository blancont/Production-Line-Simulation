import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		new Database();
		AppCommunicator appComm = new AppCommunicator();
		appComm.createCommandFromInput("single-order.json", "single-con-response.json");
	}
}
