package domain;

public interface Observer {
	void update(DrinkResponse response);
	int getOrderId();
}
