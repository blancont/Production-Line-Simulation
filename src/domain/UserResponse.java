package domain;

public class UserResponse {
	
	public int orderID;
	public int coffee_machine_id;
	public int status;
	public String statusMessage;
	public String errorMessage;
	
	public UserResponse(int orderID, int coffee_machine_id, int status, String statusMessage, String errorMessage) {
		this.orderID = orderID;
		this.coffee_machine_id = coffee_machine_id;
		this.status = status;
		this.statusMessage = statusMessage;
		this.errorMessage = errorMessage;
	}

	public String displayResponse() {
		String disp = null;
		if(status == 0) {
			disp = statusMessage + " at machine " + coffee_machine_id;
		} else {
			disp = statusMessage + " " + errorMessage + " at machine " + coffee_machine_id;
		}
		System.out.println(disp);
		return disp;
	}
	
	public void printContents() {
		System.out.println("[UserResponse] -- USER-RESPONSE CONTENTS --");
		System.out.println("orderID = " + orderID);
		System.out.println("coffee_machine_id = " + coffee_machine_id);
		System.out.println("status = " + status);
		System.out.println("status-message = " + statusMessage);
		System.out.println("error-message = " + errorMessage);
		System.out.println();
	}
}
