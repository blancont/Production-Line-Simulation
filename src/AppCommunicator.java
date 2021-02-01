
import java.util.ArrayList;

public class AppCommunicator {
	
	Command command;
	
	public String createCommandFromInput(String filename, String responseFilename) {
		this.command = DataReader.generateCommand(filename);
		return sendToControllerComm(command, responseFilename);
	}
	
	public String sendToControllerComm(Command command, String responseFilename) {
		for(ControllerCommunicator comm : Database.getControllerComms()) {
			if (command.getControllerId() == comm.getAssocId()) {
				OrderHandler handler = new OrderHandler(command, comm, this);
				return comm.takeCommand(command, handler, responseFilename);
			}
		}
		
		return "No controller found";
	}
	
	public String takeDrinkResponse(DrinkResponse response) {
		int status = response.getStatus();
		String str = status == 0 ? "Your coffee has been prepared with your desired options." : "Your coffee order has been cancelled.";
		
		UserResponse userResponse = new UserResponse(response.getOrderId(), command.getMachineId(), status, str, response.getErrorDesc());
		return userResponse.displayResponse();
	}
}

// test to make sure git is working