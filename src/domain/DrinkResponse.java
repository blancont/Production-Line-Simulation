package domain;

public class DrinkResponse {
	
	public int orderID;
	public int status;
	public String errordesc;
	public int errorcode;

	public DrinkResponse(int orderID, int status, String errordesc, int errorcode) {
		this.orderID = orderID;
		this.status = status;
		this.errordesc = errordesc;
		this.errorcode = errorcode;
	}
	
}
