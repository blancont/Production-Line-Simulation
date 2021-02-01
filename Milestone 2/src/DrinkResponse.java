
public class DrinkResponse {
	
	private int orderID;
	private int status;
	private String errordesc;
	private int errorcode;

	public DrinkResponse(int orderID, int status, String errordesc, int errorcode) {
		this.orderID = orderID;
		this.status = status;
		this.errordesc = errordesc;
		this.errorcode = errorcode;
	}
	
	public int getOrderId() {
		return orderID;
	}
	
	public int getStatus() {
		return status;
	}

	public String getErrorDesc() {
		return errordesc;
	}
}
