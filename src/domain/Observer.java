package domain;

public interface Observer {
	public void update(DrinkResponse response);
	public int getOrderId();
}
