
public class UserResponse {
	
	private int orderID;
	private int coffee_machine_id;
	private int status;
	private String statusMessage;
	private String errorMessage;
	
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
			disp = statusMessage;
		} else {
			disp = statusMessage + " " + errorMessage;
		}
		System.out.println(disp);
		return disp;
	}
}
